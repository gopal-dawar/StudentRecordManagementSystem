package org.student.record.management.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DesignPattern {
	private DesignPattern() {
	}

	private static SessionFactory sessionFactor;

	public static SessionFactory getSessionFactory() {
		if (sessionFactor == null) {

			sessionFactor = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionFactor;
	}
}
