package com.Paiement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.Session.Admin;
import com.Session.Facture;
import com.Session.HibernateUtil;



public class PaiementDAO implements Ipaiement{

	@Override
	public void saveFacture(Facture facture) {
		        Transaction transaction = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            // start the transaction
		            transaction = session.beginTransaction();

		            // save student object
		            session.save(facture);

		            // commit the transaction
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		        }
	}

	@Override
	public void updateFacture(Facture facture) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.saveOrUpdate(facture);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public Facture getFactureById(int id) {
		 Transaction transaction = null;
		 Facture facture = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    // start the transaction
				    transaction = session.beginTransaction();

				    // get student object
				    facture= session.byId(Facture.class).getReference(id);
				     // or student = session.get(Student.class, id);
				    //or student = session.load(Student.class, id);
				   //or commit the transaction
				    transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
				
			}
	        
	        
	        return  facture;
	}

	@Override
	public List<Facture> getAllFacture() {
		        Transaction transaction = null;
		        List <Facture > facture = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            // start the transaction
		            transaction = session.beginTransaction();

		            // get students
		            facture = session.createQuery("from Facture").list();
		            //student = session.load(Student.class, id);
		            // commit the transaction
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		        }
		        return facture;
	}

	@Override
	public void deleteFacture(int id) {
		Transaction transaction = null;
        Facture facture = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            facture = session.get(Facture.class, id);
            // get student object
            session.delete(facture);
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
