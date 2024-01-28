package in.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class mapDemo {
	public static void main(String[] args) {

		System.out.println("========Jai Shree Ganesh========");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		// question object creation 
		Question q1 = new Question();
		q1.setQuestionId(11);
		q1.setQuestion("What is Java?");
		Answer ans1 = new Answer();
		Answer ans2 = new Answer();
		Answer ans3 = new Answer();
		ans1.setAnswerId(01);
		ans1.setAnswer("Java is a programming language");
		ans1.setQuestion(q1);
		ans2.setAnswerId(02);
		ans2.setAnswer("API to work with objects in Java");
		ans2.setQuestion(q1);
		ans3.setAnswerId(03);
		ans3.setAnswer("It has various frameworks");
		ans3.setQuestion(q1);

		List<Answer> list1 = new ArrayList<>();
		list1.add(ans1);
		list1.add(ans2);
		list1.add(ans3);
		q1.setAns(list1);

		// fetching data
		Question question = session.get(Question.class, 12);
		System.out.println(question);
		// saving the objects to database
		session.save(q1);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);

		tx.commit();
		session.close();
		factory.close();
		System.out.println("============Done============");
	}

}
