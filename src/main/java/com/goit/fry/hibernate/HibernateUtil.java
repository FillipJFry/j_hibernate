package com.goit.fry.hibernate;

import com.goit.fry.hibernate.entities.*;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final HibernateUtil inst = new HibernateUtil();

	@Getter
	private final SessionFactory sessionFactory;

	private HibernateUtil() {

		sessionFactory = new Configuration()
				.addAnnotatedClass(Client.class)
				.addAnnotatedClass(Planet.class)
				.addAnnotatedClass(Ticket.class)
				.buildSessionFactory();
	}

	public static HibernateUtil getInst() {

		return inst;
	}

	public void close() {

		sessionFactory.close();
	}
}
