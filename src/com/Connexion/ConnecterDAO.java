package com.Connexion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.Admin;
import com.Session.HibernateUtil;

public class ConnecterDAO implements Iconnecter {

	@Override
	public void saveAdmin(Admin admn) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(admn);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}

	@Override
	public void updateAd(Admin Admin) {
		// TODO Auto-generated method stub 	
		
	     Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.saveOrUpdate(Admin);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public Admin getAdById(int id) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        Admin admin = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    // start the transaction
				    transaction = session.beginTransaction();

				    // get student object
				    admin= session.byId(Admin.class).getReference(id);
				     // or student = session.get(Student.class, id);
				    //or student = session.load(Student.class, id);
				   //or commit the transaction
				    transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
				
			}
	        
	        
	        return admin;
	}

	@Override
	public List<Admin> getAllAdmin() {
        Transaction transaction = null;
        List < Admin > admin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            admin = session.createQuery("from Admin").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return admin;
	}

	@Override
	public void deleteAd(int id) {
	      Transaction transaction = null;
	        Admin admin = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            admin = session.get(Admin.class, id);
	            // get student object
	            session.delete(admin);
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	    
		
	}

}
