package in.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class mapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("========Jai Shree Ganesh========");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		// question object creation 
		Question q1 = new Question();
		Question q2 = new Question();
		q1.setQuestionId(11);
		q1.setQuestion("What is Java?");
		q2.setQuestionId(12);
		q2.setQuestion("What is Collection framework?");
		Answer ans1 = new Answer();
		Answer ans2 = new Answer();
		ans1.setAnswerId(21);
		ans1.setAnswer("Java is a programming language");
		ans2.setAnswerId(22);
		ans2.setAnswer("API to work with objects in Java");
		q1.setAnswer(ans1);
		q2.setAnswer(ans2);

		session.save(q1);
		session.save(q2);
		session.save(ans1);
		session.save(ans2);

		tx.commit();
		session.close();
		factory.close();

		System.out.println("============Done============");
	}

}
