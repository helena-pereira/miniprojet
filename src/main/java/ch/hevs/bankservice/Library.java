package ch.hevs.bankservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Writer;
import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Book;

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
	
	Book getBook(String bookDescription);
	Writer addWriter();
	//ajouter un livre et l'associer à une catégorie
	Book addBook();
	
	//supprimer un écrivain ainsi que tous les livres qu'il a écrit	
	Writer 
}