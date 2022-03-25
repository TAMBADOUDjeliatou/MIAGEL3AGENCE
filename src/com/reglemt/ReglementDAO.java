package com.reglemt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;
import com.Session.ModeReglmt;


public class ReglementDAO implements Ireglement {


	@Override
	public List<ModeReglmt> getMode() {
		// TODO Auto-generated method stub
		
			 Transaction transaction = null;
		        List <ModeReglmt > mode = null;
		        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            // start the transaction
		            transaction = session.beginTransaction();

		            // get students
		            mode = session.createQuery("from mode").list();
		            //student = session.load(Student.class, id);
		            // commit the transaction
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		        }
		        return mode;
	}

}
