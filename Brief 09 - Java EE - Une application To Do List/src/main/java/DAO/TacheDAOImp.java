package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectDB;
import Model.Tache;

public class TacheDAOImp implements TacheDAO{
	
	private static final String INSERT_TODOS_SQL = "INSERT INTO tache"
			+ "  (title, description, deadline,  statue) VALUES " + " (?, ?, ?, ?);";

	private static final String SELECT_TODO_BY_ID = "select id,title,description,deadline,statue from tache where id_tache =?";
	private static final String SELECT_ALL_TODOS = "select * from tache";
	private static final String DELETE_TODO_BY_ID = "delete from tache where id_tache = ?;";
	private static final String UPDATE_TODO = "update tache set title = ?, username= ?, description =?, deadline =?, statue = ? where id_tache = ?;";

	public void TacheDAOImpl() {
	}

	@Override
	public void insertTodo(Tache tache) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(INSERT_TODOS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = ConnectDB.connection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL)) {
			preparedStatement.setString(1, tache.getTitle());
			preparedStatement.setString(3, tache.getDescription());
			preparedStatement.setDate(4, ConnectDB.getSQLDate(tache.getDeadline()));
			preparedStatement.setString(5, tache.getStatue());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			ConnectDB.printSQLException(exception);
		}
		
	}

	@Override
	public Tache selectTodo(int todoId) {
		Tache tache = null;
		// Step 1: Establishing a Connection
		try (Connection connection = ConnectDB.connection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID);) {
			preparedStatement.setLong(1, todoId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Integer id_tache = rs.getInt("id_tache");
				String title = rs.getString("title");
				String description = rs.getString("description");
				LocalDate deadline = rs.getDate("deadline").toLocalDate();
				String statue = rs.getString("statue");
				tache = new Tache(id_tache, title, description, deadline, statue);
			}
		} catch (SQLException exception) {
			ConnectDB.printSQLException(exception);
		}
		return tache;
	}

	@Override
	public List<Tache> selectAllTodos() {
		// using try-with-resources to avoid closing resources (boiler plate code)
				List<Tache> tache = new ArrayList<>();

				// Step 1: Establishing a Connection
				try (Connection connection = ConnectDB.connection();

						// Step 2:Create a statement using connection object
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS);) {
					System.out.println(preparedStatement);
					// Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();

					// Step 4: Process the ResultSet object.
					while (rs.next()) {
						Integer id_tache = rs.getInt("id_tache");
						String title = rs.getString("title");
						String description = rs.getString("description");
						LocalDate deadline = rs.getDate("deadline").toLocalDate();
						String statue = rs.getString("statue");
						tache.add(new Tache(id_tache, title, description, deadline, statue));
					}
				} catch (SQLException exception) {
					ConnectDB.printSQLException(exception);
				}
				return tache;
	}

	@Override
	public boolean deleteTodo(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = ConnectDB.connection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TODO_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateTodo(Tache tache) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = ConnectDB.connection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TODO);) {
			statement.setString(1, tache.getTitle());
			statement.setString(3, tache.getDescription());
			statement.setDate(4, ConnectDB.getSQLDate(tache.getDeadline()));
			statement.setString(5, tache.getStatue());
			statement.setInt(6, tache.getId_tache());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	
}
