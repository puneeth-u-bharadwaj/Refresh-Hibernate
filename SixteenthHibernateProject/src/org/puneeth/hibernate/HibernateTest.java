package org.puneeth.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.puneeth.hibernate.dto.UserDetails;
import org.puneeth.hibernate.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First Person");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
		System.exit(0);
	}

}
