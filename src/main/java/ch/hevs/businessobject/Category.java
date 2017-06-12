package ch.hevs.businessobject;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Category")
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idCategory;
	public Long getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}


	public String getDescCategory() {
		return descCategory;
	}


	public void setDescCategory(String descCategory) {
		this.descCategory = descCategory;
	}


	public Set<Book> getBooks() {
		return books;
	}


	public void setBooks(Set<Book> books) {
		this.books = books;
	}


	@Column(name="Category")
	private String descCategory;
	

	// relation + transitive persistence
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private Set<Book> books;

	public Category(){
		
	}
	
	 
	public Category(Long idCategory, String descCategory){
		this.idCategory = idCategory;
		this.descCategory = descCategory;
	}
}
