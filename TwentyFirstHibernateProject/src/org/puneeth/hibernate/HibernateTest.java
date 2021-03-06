package org.puneeth.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.puneeth.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// for (int i = 0; i < 10; i++) {
		// UserDetails user = new UserDetails();
		// user.setUserName("User " + i);
		// session.save(user);
		// }

		UserDetails user = session.get(UserDetails.class, 2);
//		session.delete(user);
		user.setUserName("Updated this username");
		session.update(user);

		session.getTransaction().commit();
		session.close();

//		System.out.println("Following are the details");
//		System.out.println(user.getUserId() + " " + user.getUserName());

		System.exit(0);
	}

}
