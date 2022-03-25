package com.Menu;

import java.awt.Menu;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.Admin;
import com.Session.HibernateUtil;

public class MenuDAO implements Imenu{
	


	@Override
	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(menu);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}

	@Override
	public void updateMe(Menu menu) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.saveOrUpdate(menu);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}

	@Override
	public Menu getAdByMe(int id) {
		 Transaction transaction = null;
	        Menu menu = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();   
				    transaction = session.beginTransaction();
				    menu= session.byId(Menu.class).getReference(id);
				    transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
				
			}
	        
	        return menu;  
	       
	}

	@Override
	public List<Menu> getAllMenu() {
		
		 Transaction transaction = null;
	        List < Menu > menu = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	
	            transaction = session.beginTransaction();

	            
	            menu = session.createQuery("from Student").list();
	        
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	        return menu;
		
	}

	@Override
	public void deleteAd(int id) {
		
        Transaction transaction = null;
    Menu menu = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            menu = session.get(Menu.class, id);
            // get student object
            session.delete(menu);
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
