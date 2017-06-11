package ch.hevs.businessobject;

import javax.persistence.Entity;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;


@Entity
@Table(name="Writer")
public class Writer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name="prenom")
	private String firstname;
	@Column(name="nom")
	private String lastname;	
	
	
	// relation + transitive persistence
	@OneToMany(mappedBy="writer", cascade = CascadeType.ALL)
	private List<Book> books;
	
		
	 
	// id 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	// firstname
	public String getFirstname() {
		return firstname;
	}
	public void setNumber(String firstname) {
		this.firstname = firstname;
	}
	
	// lastname	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	// books (FROM BOOK)
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	// constructors
	public Writer() {
	}
	public Writer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		String result = id + "-" + lastname + "-" + firstname;
		return result;
	}
}