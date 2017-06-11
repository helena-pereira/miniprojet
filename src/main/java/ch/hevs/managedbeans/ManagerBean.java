package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bankservice.Library;
import ch.hevs.bankservice.LibraryBean;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

/**
 * TransferBean.java
 * 
 */

public class ManagerBean
{
	private List<Book> books;
	private List<Writer> writers;
	private List<Category> categories;
	private LibraryBean libraryBean;
	private Library library;
	
    
    @PostConstruct
    public void initialize() throws NamingException {
    	
    	// use JNDI to inject reference to book EJB
    	InitialContext ctx = new InitialContext();
    	libraryBean = (LibraryBean) ctx.lookup("java:global/MiniProject-0.0.1-SNAPSHOT/LibraryBean!ch.hevs.bankservice.LibraryBean");
    	library = (Library) ctx.lookup("java:global/MiniProject-0.0.1-SNAPSHOT/LibraryBean!ch.hevs.bankservice.Library");
 
    	
    }
}