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
		q1.setQuestionId(21);
		q1.setQuestion("What is Hibernate?");
		Answer ans1 = new Answer();
		Answer ans2 = new Answer();
		Answer ans3 = new Answer();
		ans1.setAnswerId(31);
		ans1.setAnswer("Hibernate is a ORM tool");
		ans1.setQuestion(q1);
		ans2.setAnswerId(32);
		ans2.setAnswer("It is used to map class objects to sql table");
		ans2.setQuestion(q1);



		List<Answer> list1 = new ArrayList<>();
		list1.add(ans1);
		list1.add(ans2);

		q1.setAns(list1);

		// fetching data
		Question question = session.get(Question.class, 21);
		System.out.println(question.getQuestion());

		// lazy loading ;;;;means it loads the answer object only when its called but it has changed now to eager by providing fetch type in Question class
		System.out.println(question.getAns().size());

		// saving the objects to database
		//		session.save(q1);
		//		session.save(ans1);
		//		session.save(ans2);


		tx.commit();
		session.close();
		factory.close();
		System.out.println("============Done============");
	}

}
