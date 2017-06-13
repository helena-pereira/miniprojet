package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
	//private List<Category> categories;
	private Library library;
    private String transactionResult;
    private Category cat;

    
    //category
	private Set<Category>listCategories;
	private String stringSelectedCategory;

	//write
	private String writerFirstName;
	private String writerLastName;

	
	//book
	private String bookTitle;
	private int bookPublicationYear;
	private String bookDescription;
	private Category currentCategory;
	private List<String> _descriptionCategory;
	private String descriptionCategory;
	private String writerName;
	
	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}


	private Set<Writer>listWriters;



	
    
    public List<String> get_descriptionCategory() {
		return _descriptionCategory;
	}

	public void set_descriptionCategory(List<String> _descriptionCategory) {
		this._descriptionCategory = _descriptionCategory;
	}

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
    
    /*
    public List<Category> getAllCategories(){
    	return categories;
    }
    */
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
	
	
	
	
	//about Writer
	public String addWriter(){
    	Writer w = new Writer();
    	w.setFirstname(writerFirstName);
    	w.setLastname(writerLastName);
    	try{
    		library.addWriter(w);
			this.transactionResult="Success!";

    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	

    	return "showWriter";
    }

	public String getWriterFirstName() {
		return writerFirstName;
	}

	public void setWriterFirstName(String writerFirstName) {
		this.writerFirstName = writerFirstName;
	}

	public String getWriterLastName() {
		return writerLastName;
	}

	public void setWriterLastName(String writerLastName) {
		this.writerLastName = writerLastName;
	}

	
	
	
	
	
	
	
	
	// Create object from the selected list of athelete.We will push it into the selected Athlete
	public void generateObjectFromStringCategory()
	{
		// we will store information in a array because the result is like "firstname-lastname"
		String []arrayCategoryInformation =stringSelectedCategory.split("/");
		//we search in the data base the corresponding string. remember: 0 fristname, 1 lastname
		currentCategory= library.getCategory(arrayCategoryInformation[0]);
	}

	
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getBookPublicationYear() {
		return bookPublicationYear;
	}

	public void setBookPublicationYear(int bookPublicationYear) {
		this.bookPublicationYear = bookPublicationYear;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
    

	
	public Set<Category> getListCategories() {
		listCategories = library.getListCategories();
		return listCategories;
	}
	
	public Set<Writer> getListWriters() {
		listWriters = library.getListWriters();
		return listWriters;
	}

	
	
	public String getStringSelectedCategory() {
		return stringSelectedCategory;
	}

	public void setStringSelectedCategory(String stringSelectedCategory) {
		this.stringSelectedCategory = stringSelectedCategory;
	}
	
	
	 public String addBook() {
	 
		 
		// generateObjectFromStringCategory();
			
	    	Book b = new Book();
	    	b.setTitle(bookTitle);
	    	b.setPublicationYear(bookPublicationYear);
	    	b.setDescription(bookDescription);
	    	b.setCategory(library.getCategory(descriptionCategory));
	    	b.setWriter(library.getWriterFirstName(writerName));
	    	
	    	
	    	try{
	    		library.addBook(b);
				this.transactionResult="Your book have been registered!";
				this.transactionResult="<br>"+ currentCategory;
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	

	    	return "showWriter";
	    	
	    	
	 }
	
}
