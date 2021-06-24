import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.te.Quizproject.beans.Category;
import com.te.Quizproject.beans.Questions;
import com.te.Quizproject.configration.CategoryConfig;

public class OneToMany {
	static EntityManagerFactory emf = null;
	static EntityManager em = null;
	static	EntityTransaction t=null;
	
public static void main(String[] args) {
	
	ApplicationContext context = new AnnotationConfigApplicationContext(CategoryConfig.class);

	Category c1= context.getBean(Category.class);
	c1.setCid(10);
	c1.setCname("Entertainment");
	
	Category c2= context.getBean(Category.class);
	c2.setCid(20);
	c2.setCname("Technology");
	
	ApplicationContext context1 = new AnnotationConfigApplicationContext(CategoryConfig.class);
	
Questions qe1	= context1.getBean(Questions.class);
	qe1.setId(1);
	qe1.setQues("National Bird of India?");
	qe1.setOptionA("A-Pegion");
	qe1.setOptionB("B-Parrot");
	qe1.setOptionC("C-Peacock");
	qe1.setOptionD("D-Sparrow");
	qe1.setCorrectOption("C");
	qe1.setCategory(c1);
	
	Questions qe2	= context1.getBean(Questions.class);
	qe2.setId(2);
	qe2.setQues("National Animal of India");
	qe2.setOptionA("A-Lion");
	qe2.setOptionB("B-Tiger");
	qe2.setOptionC("C-Cow");
	qe2.setOptionD("D-Hippo");
	qe2.setCorrectOption("B");
	qe2.setCategory(c1);
	
	Questions qe3	= context1.getBean(Questions.class);
	qe3.setId(3);
	qe3.setQues("Capital of India?");
	qe3.setOptionA("A-Delhi");
	qe3.setOptionB("B-Chennai");
	qe3.setOptionC("C-Bengaluru");
	qe3.setOptionD("D-Hyderabad");
	qe3.setCorrectOption("A");
	qe3.setCategory(c1);
	
	Questions qe4	= context1.getBean(Questions.class);
	qe4.setId(4);
	qe4.setQues("President of India?");
	qe4.setOptionA("A-RamNath Kovind");
	qe4.setOptionB("B-Narendra Modi");
	qe4.setOptionC("C-Mukesh Ambani");
	qe4.setOptionD("D-Amit Shah");
	qe4.setCorrectOption("B");
	qe4.setCategory(c1);
	
	Questions qe5	= context1.getBean(Questions.class);
	qe5.setId(5);
	qe5.setQues("Teacher's day celebrated on?");
	qe5.setOptionA("A-20 december");
	qe5.setOptionB("B-26 january");
	qe5.setOptionC("C-15 august");
	qe5.setOptionD("D-2 october");
	qe5.setCorrectOption("D");
	qe5.setCategory(c1);
	
	
	
	ArrayList<Questions> eq = new ArrayList<Questions>();
	eq.add(qe1);
	eq.add(qe2);
	eq.add(qe3);
	eq.add(qe4);
	eq.add(qe5);
	
	
	
	Questions qt1	= context1.getBean(Questions.class);
	qt1.setId(6);
	qt1.setQues("The first mechanical computer designed by Charles Babbage was called ?");
	qt1.setOptionA("A-Abacus");
	qt1.setOptionB("B-Analytical Engine");
	qt1.setOptionC("C-Calculator");
	qt1.setOptionD("D-Processor");
	qt1.setCorrectOption("B");
	qt1.setCategory(c2);
	
	Questions qt2	= context1.getBean(Questions.class);
	qt2.setId(7);
	qt2.setQues("Which of the following is the most powerful type of computer ?");
	qt2.setOptionA("A-Super-micro");
	qt2.setOptionB("B-Super conductor");
	qt2.setOptionC("C-Super computer");
	qt2.setOptionD("D-Megaframe");
	qt2.setCorrectOption("C");
	qt2.setCategory(c2);
	
	Questions qt3	= context1.getBean(Questions.class);
	qt3.setId(8);
	qt3.setQues("Which is a single integrated circuit?");
	qt3.setOptionA("A-Gate");
	qt3.setOptionB("B-Mother Board");
	qt3.setOptionC("C-Chip");
	qt3.setOptionD("D-CPU");
	qt3.setCorrectOption("A");
	qt3.setCategory(c2);
	
	Questions qt4	= context1.getBean(Questions.class);
	qt4.setId(9);
	qt4.setQues("C is ?");
	qt4.setOptionA("A-A machine language");
	qt4.setOptionB("B-A third generation high level language");
	qt4.setOptionC("C-An assembly language");
	qt4.setOptionD("D-All of the above");
	qt4.setCorrectOption("B");
	qt4.setCategory(c2);
	
	Questions qt5	= context1.getBean(Questions.class);
	qt5.setId(10);
	qt5.setQues("Web pages are written using ?");
	qt5.setOptionA("A-FTP");
	qt5.setOptionB("B-HTTP");
	qt5.setOptionC("C-URL");
	qt5.setOptionD("D-HTML");
	qt5.setCorrectOption("D");
	qt5.setCategory(c2);
	
	
	
	ArrayList<Questions> tq = new ArrayList<Questions>();
	tq.add(qt1);
	tq.add(qt2);
	tq.add(qt3);
	tq.add(qt4);
	tq.add(qt5);
	
	
	c1.setQuestions(eq);
	c2.setQuestions(tq);
	
	
	
	
	
	

		emf=Persistence.createEntityManagerFactory("MappingData");
		em=emf.createEntityManager();
		 t=em.getTransaction();
		 
//		 t.begin();
//		 em.persist(c1);
//		 em.persist(c2);
//		 t.commit();
		 
		 
		 Scanner sc = new Scanner(System.in);
		
		 System.out.println("Enter your name");
         String name = sc.nextLine();
         
         System.out.println("choose your category");
         System.out.println("10-General Knowledge");
         System.out.println("20-Technology");
		 int id = Integer.parseInt(sc.nextLine());
		 getQuetions(id);
		 
}
		
	 
		 
		public static void getQuetions(int id) {
			 Scanner sc = new Scanner(System.in);
			 
			 int result=0;
	        
	     
			 String s = "from Category where cid=:id ";
			 Query q = em.createQuery(s);
			 q.setParameter("id", id);
			 Category c = (Category) q.getSingleResult();
			 System.out.println(c.getCname());
			 List<Questions> que = c.getQuestions();
			 
			 for (Questions m : que) {
				 System.out.println(m.getQues());
				 System.out.println(m.getOptionA());
				 System.out.println(m.getOptionB());
				 System.out.println(m.getOptionC());
				 System.out.println(m.getOptionD());
				 System.out.println("enter your ans");
				 String ans = sc.nextLine();
				String corret= m.getCorrectOption();
				 if(corret.equalsIgnoreCase(ans)) {
					 System.out.println("correct ans");
					 result ++;
				 }
				 else
					 System.err.println("worng ans");
				
			}
			 System.out.println("your score is5/"+result);
			 
		}
		 

		 
		 

}