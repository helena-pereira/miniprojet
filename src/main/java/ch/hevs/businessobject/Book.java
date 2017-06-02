package ch.hevs.businessobject;

import javax.persistence.*;

@Entity
@Table(name="Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idBook;
	@Column(name="Title")
	private String title;
	@Column(name="Publication Year")
	private int publicationYear;
	@Column(name="Description")
	private String description;
	
	//relation FK
	@ManyToOne
	@JoinColumn(name = "Writer")
	private Writer writer;
	
	//relation FK
	@ManyToOne
	@JoinColumn(name = "Category")
	private Category category;
	
	
	public Book(){
		
	}
	
	public Book(Long idBook, String title, int publicYear, String description){
		this.idBook = idBook;
		this.title = title;
		this.publicationYear = publicYear;
		this.description = description;
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
	
	public Writer getIdWriter() {
		return writer;
	}
	
	public void setIdWriter(Writer writer) {
		this.writer = writer;
	}
	
	public Category getIdCategory() {
		return category;
	}
	
	public void setIdCategory(Category idCategory) {
		this.category = idCategory;
	}
}
