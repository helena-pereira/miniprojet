package ch.hevs.businessobject;

import javax.persistence.*;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idBook;
	private String title;
	private int publicationYear;	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "FK_WRITER")
	private Writer idWriter;
	
	private Long idCategory;
	
	
	public Book(){
		
	}
	
	public Book(Long idBook, String title, int publicYear, String description){
		
	}
	
	
	public Long getIdBook() {
		return idBook;
	}
	
	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPublicationYear() {
		return publicationYear;
	}
	
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getIdWriter() {
		return idWriter;
	}
	
	public void setIdWriter(Long idWriter) {
		this.idWriter = idWriter;
	}
	
	public Long getIdCategory() {
		return idCategory;
	}
	
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
}
