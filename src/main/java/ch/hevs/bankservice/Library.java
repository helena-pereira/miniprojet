package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import ch.hevs.businessobject.Writer;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;

/**** STEPHANIE **/
 
@Local

/*
public interface Bank {

	Account getAccount(String accountDescription, String lastnameOwner);
	
	public List<Account> getAccountListFromClientLastname(String lastname);

	void transfer(Account compteSrc, Account compteDest, int montant) throws Exception;

	List<Client> getClients();

	Client getClient(long clientid);
}
*/


public interface Library {
	
	Book getBook(int idBook);
	
	void addCategory(Category category) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;
	
	//ajouter un �crivain
	void addWriter(Writer writer);
	
	//ajouter un livre et l'associer � une cat�gorie
	Book addBook();
	
	
	
	
	//supprimer un �crivain ainsi que tous les livres qu'il a �crit	
	void deleteWriter();
	
	//supprimer un livre
	void deleteBook();
	
	
	
	
	//update un �crivain
	Writer udateWriter(int writer);
	
	//update un livre
	Book udateBook(int book);
	
	
	
	//afficher la liste de �crivains
	List<Writer> getWriters();
	
	//aficher la liste des livres
	List<Book> getBooks();
	
	//afficher la liste des cat�gories
	List<Category> getCategories();
	
	
	
	
}