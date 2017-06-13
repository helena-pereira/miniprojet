package ch.hevs.bankservice;

import java.util.List;
import java.util.Set;

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
	
	
	//ajouter une catégorie
	void addCategory(Category category) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;
	
	//ajouter un écrivain
	void addWriter(Writer writer) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;
	
	//ajouter un livre et l'associer à une catégorie
	void addBook(Book book) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;
	
	
	
	
	//supprimer un écrivain ainsi que tous les livres qu'il a écrit	
	void deleteWriter();
	
	//supprimer un livre
	void deleteBook();
	
	//supprimer une catégorie
	void deleteCategory();
	
	
	
	//update un écrivain
	Writer updateWriter(int writer);
	
	//update un livre
	Book updateBook(int book);
	
	//update une catégorie
	Category updateCategory(int category);
	Category getCategory(String description);
	Writer getWriterFirstName(String firstname);
	
	//afficher la liste de écrivains
	List<Writer> getWriters();
	
	//aficher la liste des livres
	List<Book> getBooks();
	
	//afficher la liste des catégories
	List<Category> getCategories();
	Set<Category> getListCategories();
	Set<Writer> getListWriters();
	
	
	
}