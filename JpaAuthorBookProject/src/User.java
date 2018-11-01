

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.bean.Author;
import com.cg.bean.Book;

public class User {

	public static void main(String[] args) {
		
		EntityManagerFactory fact = 
				Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = fact.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		
		Book bk = new Book();
		bk.setBookIsbn(130);
		bk.setBookPrice(600);
		bk.setBookTitle("Java Programming");
	


		Book bk1 = new Book();
		bk1.setBookIsbn(131);
		bk1.setBookPrice(700);
		bk1.setBookTitle("Android Programming");

		Author aut = new Author();
		aut.setAuthorId(109);
		aut.setAuthorName("Rahul");

		aut.addBooks(bk);
		aut.addBooks(bk1);

		Author aut1 = new Author();
		aut1.setAuthorId(110);
		aut1.setAuthorName("Shikhar");

		aut1.addBooks(bk);
		aut1.addBooks(bk1);

		tran.begin();
		em.persist(aut);
		em.persist(aut1);
		tran.commit();
		
		System.out.println("Records added sucesfully!!");

	}

}
