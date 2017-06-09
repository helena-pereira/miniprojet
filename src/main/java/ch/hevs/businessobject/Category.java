package ch.hevs.businessobject;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Category")
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idCategory;
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
