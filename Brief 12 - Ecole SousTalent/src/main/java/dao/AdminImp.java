package dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import dao.DAO;
import entities.*;
import util.HibernateUtil;

public class AdminImp implements DAO <Admin> {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public void Add(Admin admin) {
		Session session = sessionFactory.openSession();		
		// start a transaction
		session.beginTransaction();
		// save an admin object
		session.save(admin);
		// commit transaction
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void Delete(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
		// start a transaction
        session.beginTransaction();
        Admin user = (Admin) session.get(Admin.class, admin.getIdadmin());
        session.delete(user);
		// commit transaction
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void Update(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
		// start a transaction
        session.beginTransaction();
        session.update(admin);
		// commit transaction
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void SelectAll(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
		// start a transaction
        session.beginTransaction();
        admin = (Admin) session.get(Admin.class, admin.getIdadmin());
		// commit transaction
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void SelectById(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
		// start a transaction
        session.beginTransaction();
        admin = (Admin) session.get(Admin.class, admin.getIdadmin());
		// commit transaction
        session.getTransaction().commit();
		session.close();
	}
	
	public boolean validate(String username, String password) {
		System.out.println("hihihih");
		Transaction transaction = null;
		Admin admin = null;
		boolean valid=false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			admin = (Admin) session.createQuery("FROM Admin A WHERE A.username = :username")
					.setParameter("username", username).uniqueResult();
			if (admin != null && admin.getPassword().equals(password)) {
				valid= true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return valid;
	}

}
