package ch.hevs.bankservice;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;
 
@Stateful
public class LibraryBean implements Library {
	
	@PersistenceContext(name = "BankPU", type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	//used for the transaction. We will work with transaction (mandatory)
	private UserTransaction transaction ;
	// used for the security part, to check if the user has the admin right or only guest right
	@Resource
	private SessionContext ctx;
	
	
	
	
	@Override
	public Book getBook(int id) {
		Query query = em.createQuery("FROM Book a WHERE a.id=:id");
		query.setParameter("id", (long)id);
		return (Book) query.getSingleResult();
	}
	
	
	
	
	
	@Override
	public void addWriter(Writer writer) {
		try
		{
			transaction.begin();
			em.persist(em.contains(writer) ? writer : em.merge(writer));
			transaction.commit();
		}
		catch (Exception ex)
		{	
		}
	}
	@Override
	public Book addBook() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteWriter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteBook() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Writer udateWriter(int writer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Book udateBook(int book) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	@Override
	public List<Writer> getWriters() {
		return em.createQuery("FROM Writer").getResultList();		
	}
	
	
	@Override
	public List<Book> getBooks() {
		return em.createQuery("FROM Book").getResultList();		
	}
	
	
	@Override
	public List<Category> getCategories() {
		return em.createQuery("FROM Category").getResultList();		

	}

	
	
	// get the current session context
		public SessionContext getCtx() {
			return ctx;
		}
		public void setCtx(SessionContext ctx) {
			this.ctx = ctx;
		}
		
		
		
	
	
	/*
	
	public Writer getWriter(String writerDescription, String titleBook) {
		Query query = em.createQuery("FROM Writer w WHERE w.description=:description AND w.book.title=:titleBook");
		query.setParameter("description", writerDescription);
		query.setParameter("title", titleBook);
		
		Writer writer= (Writer) query.getSingleResult();
		System.out.println("ID account called from getBook(): "+writer.getId());
		return writer;
	}
	
	public List<Account> getAccountListFromClientLastname(String lastname) {
		return (List<Account>) em.createQuery("SELECT c.accounts FROM Client c where c.lastname=:lastname").setParameter("lastname", lastname).getResultList();
	}

	public void transfer(Account srcAccount, Account destAccount, int amount) {
		
		System.out.println("ID source account called from transfer(): " + srcAccount.getId());
		System.out.println("ID destination account called from transfer(): " + destAccount.getId());
		
	/*	Account srcRealAccount = em.merge(srcAccount);
		Account destRealAccount = em.merge(destAccount);
		srcRealAccount.debit(amount);
		destRealAccount.credit(amount); */
		
		// for use with EPC and stateful
		
	/*
		em.persist(srcAccount);
		em.persist(destAccount);
		srcAccount.debit(amount);
		destAccount.credit(amount); 
	}

	public List<Client> getClients() {
		return em.createQuery("FROM Client").getResultList();
	}
	
	public Client getClient(long clientid) {
		return (Client) em.createQuery("FROM Client c where c.id=:id").setParameter("id", clientid).getSingleResult();
	}*/

}
