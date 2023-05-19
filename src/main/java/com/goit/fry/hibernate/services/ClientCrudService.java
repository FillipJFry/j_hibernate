package com.goit.fry.hibernate.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.goit.fry.hibernate.HibernateUtil;
import com.goit.fry.hibernate.entities.Client;

import java.util.List;

public class ClientCrudService {

	public Client create(String clientName) {

		Client client = new Client(clientName);
		try(Session session = HibernateUtil.getInst().getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();
			session.persist(client);
			transaction.commit();
		}
		return client;
	}

	public Client read(long id) {

		Client client;
		try(Session session = HibernateUtil.getInst().getSessionFactory().openSession()) {

			client = session.get(Client.class, id);
		}
		return client;
	}

	public void update(long id, String newName) {

		Client client = new Client(id, newName);
		try(Session session = HibernateUtil.getInst().getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();
			session.merge(client);
			transaction.commit();
		}
	}

	public void delete(long id) {

		Client client = new Client(id);
		try(Session session = HibernateUtil.getInst().getSessionFactory().openSession()) {

			Transaction transaction = session.beginTransaction();
			session.remove(client);
			transaction.commit();
		}
	}

	public List<Client> listAll() {

		return null;
	}
}