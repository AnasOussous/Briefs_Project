package main;

import org.hibernate.Session;

import dao.*;
import entities.*;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub?:
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		
		//----------------------Imp--------------------------
        AdminImp adm = new AdminImp();
        CourImp cour = new CourImp();
        EtudiantImp etd = new EtudiantImp();
        ProfImp prof = new ProfImp();
        
      //----------------------CRUD Etudiant--------------------------
//        Etudiant etudiant = new Etudiant("anas","20","Men");
//        dao.insertEmployee(etudiant);
//        Admin admin = new Admin(1,"Anas","a","a");
//        adm.Add(admin);
        
//        System.out.println(dao.deleteEmployee(2));
        
//        etd.Add(etudiant);
//        etd.Delete(etudiant);
//        etd.Update(etudiant);
//        etd.SelectAll(etudiant);
        
		HibernateUtil.getSessionFactory().close();
	}
}
