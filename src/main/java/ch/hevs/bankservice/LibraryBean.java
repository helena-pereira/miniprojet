package ch.hevs.bankservice;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;
 
@Stateful
public class LibraryBean implements Library {
	
	@PersistenceContext(name = "BankPU", type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	//used for the transaction. We will work with transaction (mandatory)
	private UserTransaction transaction ;
	// used for the security part, to check if the user has the admin right or only guest right
	@Resource
	private SessionContext ctx;
	
	
	
	
	@Override
	public Book getBook(int id) {
		Query query = em.createQuery("FROM Book a WHERE a.id=:id");
		query.setParameter("id", (long)id);
		return (Book) query.getSingleResult();
	}
	
	

	@Override
	public void addCategory(Category category) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
			//transaction = ctx.getUserTransaction();
			//transaction.begin();
			em.persist(em.contains(category) ? category : em.merge(category));
			//transaction.commit();	
	}
	
	@Override
	public void addWriter(Writer writer) {
			//transaction = ctx.getUserTransaction();
			//transaction.begin();
			em.persist(em.contains(writer) ? writer : em.merge(writer));
			//transaction.commit();
		
}
	
	
	@Override
	public void addBook(Book book) {
		//transaction = ctx.getUserTransaction();
		//transaction.begin();
		em.persist(em.contains(book) ? book: em.merge(book));
		//transaction.commit();
	}
	@Override
	public void deleteWriter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteBook() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Writer updateWriter(int writer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Book updateBook(int book) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Category updateCategory(int category) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	@Override
	public List<Writer> getWriters() {
		return em.createQuery("FROM Writer").getResultList();		
	}
	
	
	@Override
	public List<Book> getBooks() {
		return em.createQuery("FROM Book").getResultList();		
	}
	
	
	@Override
	public List<Category> getCategories() {
		return em.createQuery("FROM Category").getResultList();		

	}

	
	
	// get the current session context
		public SessionContext getCtx() {
			return ctx;
		}
		public void setCtx(SessionContext ctx) {
			this.ctx = ctx;
		}

		@Override
		public void deleteCategory() {
			// TODO Auto-generated method stub
			
		}



		// gest the full list of categories
		public Set<Category>getListCategories()
		{
			return new LinkedHashSet<Category> (em.createQuery("FROM Category").getResultList());
		}
		
		



		@Override
		public Category getCategory(String description) {
			
			Query query = em.createQuery("FROM Category a WHERE a.description=:description");
			query.setParameter("description", description);
			
			return (Category) query.getSingleResult();
		}



		@Override
		public Set<Writer> getListWriters() {
				return new LinkedHashSet<Writer> (em.createQuery("FROM Writer").getResultList());
			
		}



		@Override
		public Writer getWriterFirstName(String firstname) {
			Query query = em.createQuery("FROM Writer a WHERE a.firstname=:firstname");
			query.setParameter("firstname", firstname);
			
			return (Writer) query.getSingleResult();
		}



		
		
		
	
	


}
