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
import javax.persistence.Column;


@Entity
@Table(name="Writer")
public class Writer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;	
	
	// relations
	@ManyToOne
	@JoinColumn(name = "FK_CLIENT")
	private Client owner;

	
	// relation
	@OneToMany(mappedBy="Book")
	private Set<Book> books;
	
	
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
	

/*
	
	// owner (from Client)
	public Client getOwner() {
		return owner;
	}
	public void setOwner(Client owner) {
		this.owner = owner;
	}


	// methods
	public void debit(int amount) {
		long newAmount = getSaldo() - amount;
		setSaldo(newAmount);
	}
	
	public void credit(int amount) {
		setSaldo(getSaldo() + amount);
	}
*/
	// constructors
	public Writer() {
	}
	public Writer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@PostPersist
	public void acknowledgePersist() {
		System.out.println("Writer persisted!!!");
	}
}