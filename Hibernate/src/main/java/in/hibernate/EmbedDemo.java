package in.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmbedDemo {

	public static void main(String[] args) {
		// configuration
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// student ka object jisme certificate embed krege
		Student st = new Student();
		st.setId(204);
		st.setName("Avinash Jamal");
		st.setCity("Tamil Nadu");

		Certificate certificate = new Certificate("Java","2 months");
		st.setCerti(certificate);

		// transaction start krte h
		Transaction tx = session.beginTransaction();
		session.save(st);
		Student student = session.get(Student.class,203);
		System.out.println(student);
		tx.commit();
		factory.close();

		System.out.println("==============Done===========");
	}

}
