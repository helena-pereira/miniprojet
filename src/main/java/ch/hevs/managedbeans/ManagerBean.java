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
	private Library library;
	private String descriptionCategory;
    private String transactionResult;

	
	
    
    @PostConstruct
    public void initialize() throws NamingException {
    	
    	// use JNDI to inject reference to book EJB
    	InitialContext ctx = new InitialContext();
    	library = (Library) ctx.lookup("java:global/MiniProject-0.0.1-SNAPSHOT/LibraryBean!ch.hevs.bankservice.Library"); 
    }
    
    public List<Book> getAllBooks(){
    	return books;
    }
    
    public List<Writer> getAllWriters(){
    	return writers;
    }
    
    public List<Category> getAllCategories(){
    	return categories;
    }
    
    public String addCategory(){
    	Category c = new Category();
    	c.setDescCategory(descriptionCategory);
    	try{
    		library.addCategory(c);
			this.transactionResult="Success!";

    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	

    	return "showCategory";
    }
    
    
 // destinationClientName
    public String getDescriptionCategory () {
    	return descriptionCategory;
    }
    public void setDescriptionCategory (final String descriptionCategory) {
    	this.descriptionCategory=descriptionCategory;
    }
    
    
 // transactionResult
    public String getTransactionResult () {
    	return transactionResult;
    }
	public void setTransactionResult(String transactionResult) {
		this.transactionResult = transactionResult;
	}
}
