package com.Propriete;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;
import com.Session.Proprietes;

public class ProprieteDAO implements Ipropriete{

	@Override
	public void savePropriete(Proprietes propriete) {
		   Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(propriete);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	}

	@Override
	public void updateP(Proprietes propriete) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.saveOrUpdate(propriete);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public Proprietes getPById(int id) {
		  Transaction transaction = null;
		  Proprietes propriete = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    // start the transaction
				    transaction = session.beginTransaction();

				    // get student object
				    propriete= session.byId(Proprietes.class).getReference(id);
				     // or student = session.get(Student.class, id);
				    //or student = session.load(Student.class, id);
				   //or commit the transaction
				    transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
				
			}
	        
	        
	        return propriete;
	}

	@Override
	public List<Proprietes> getP() {
		 Transaction transaction = null;
	        List < Proprietes > propriete = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // get students
	            propriete = session.createQuery("from Proprietes").list();
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	        return propriete;
	}

	@Override
	public void deleteP(int id) {
		  Transaction transaction = null;
		  Proprietes propriete = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            propriete = session.get(Proprietes.class, id);
	            // get student object
	            session.delete(propriete);
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
