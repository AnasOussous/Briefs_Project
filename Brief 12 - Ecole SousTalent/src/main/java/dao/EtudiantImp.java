package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.DAO;
import entities.*;


public class EtudiantImp implements DAO<Etudiant> {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void Add(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(etudiant);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void Delete(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Etudiant user = (Etudiant) session.get(Etudiant.class, etudiant.getIdetudiant());
        session.delete(user);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void Update(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(etudiant);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void SelectAll(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        etudiant = (Etudiant) session.get(Etudiant.class, etudiant.getIdetudiant());
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public void SelectById(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        etudiant = (Etudiant) session.get(Etudiant.class, etudiant.getIdetudiant());
        session.getTransaction().commit();
		session.close();
	}

}
