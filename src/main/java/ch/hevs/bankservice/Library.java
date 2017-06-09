package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;

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
	
	//ajouter un écrivain
	void addWriter(Writer writer);
	
	//ajouter un livre et l'associer à une catégorie
	Book addBook();
	
	
	
	
	//supprimer un écrivain ainsi que tous les livres qu'il a écrit	
	void deleteWriter();
	
	//supprimer un livre
	void deleteBook();
	
	
	
	
	//update un écrivain
	Writer udateWriter(int writer);
	
	//update un livre
	Book udateBook(int book);
	
	
	
	//afficher la liste de écrivains
	List<Writer> getWriters();
	
	//aficher la liste des livres
	List<Book> getBooks();
	
	//afficher la liste des catégories
	List<Category> getCategories();
	
	
	
	
}