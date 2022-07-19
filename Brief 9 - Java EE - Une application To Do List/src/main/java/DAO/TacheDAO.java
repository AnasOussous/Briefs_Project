package DAO;

import java.sql.SQLException;
import java.util.List;

import Model.Tache;

public interface TacheDAO {
	void insertTodo(Tache tache) throws SQLException;

	Tache selectTodo(int todoId);

	List<Tache> selectAllTodos();

	boolean deleteTodo(int id) throws SQLException;

	boolean updateTodo(Tache todo) throws SQLException;
}
