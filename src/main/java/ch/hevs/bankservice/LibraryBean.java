package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Client;

@Stateful
public class LibraryBean implements Library {
	
	@PersistenceContext(name = "BankPU", type=PersistenceContextType.EXTENDED)
	private EntityManager em;

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
	}

	@Override
	public Book getBook(String bookDescription) {
		// TODO Auto-generated method stub
		return null;
	}
}
