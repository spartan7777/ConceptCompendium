package ogedengbe.tosan.communication;

import ogedengbe.tosan.model.Concept;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

//public class ConceptDao {

//    private final Logger logger = LogManager.getLogger(this.getClass());
//    SessionFactory sessionFactoryOne = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets a list of all concepts
     * @ return all the concepts
     */
//    public List<Concept> getAllConcepts() {
//        Session sessionOne = sessionFactoryOne.openSession();
//        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
 //       CriteriaQuery<Concept> queryOne = builderOne.createQuery(Concept.class);
 //       Root<Concept> rootOne = queryOne.from(Concept.class);
 //       List<Concept> concepts = sessionOne.createQuery(queryOne).getResultList();
 //       sessionOne.close();
//        return concepts;
//    }

    /**
     * Gets concepts by name
     * @param conceptName the name to search for
     * @return the concepts that are found
     */
//    public List<Concept> getConceptsByName(String conceptName) {
//        Session sessionOne = sessionFactoryOne.openSession();
//        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
 //       CriteriaQuery<Concept> queryOne = builderOne.createQuery(Concept.class);
//        Root<Concept> rootOne = queryOne.from(Concept.class);
//        Expression<String> propertyPath = rootOne.get("lastName");
 //       queryOne.where(builderOne.like(propertyPath, "%" + conceptName + "%"));
//        List<Concept> concepts = sessionOne.createQuery(queryOne).getResultList();
 //       sessionOne.close();
 //       //logger.info("Here is the select all statement " + concepts);
 //       return concepts;
 //   }

    /**
     * Gets concept by Id
     * @param id the concept id to search for
     * @return the result concept
     */
//    public Concept getConceptsById(int id) {
//        Session sessionOne = sessionFactoryOne.openSession();
//        Concept concept = sessionOne.get(Concept.class, id);
 //       sessionOne.close();
 //       //logger.info("Here is the select all statement " + concept);
 //       return concept;
 //   }

    /**
     * Get concept by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of concepts meeting the criteria
     */
 //   public List<Concept> getByPropertyEqual(String propertyName, String value) {
 //       Session sessionOne = sessionFactoryOne.openSession();
 //       logger.debug("Searching for concept with " + propertyName + " = " + value);
 //       CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
 //       CriteriaQuery<Concept> queryOne = builderOne.createQuery( Concept.class );
 //       Root<Concept> rootOne = queryOne.from( Concept.class );
 //       queryOne.select(rootOne).where(builderOne.equal(rootOne.get(propertyName), value));
 //       List<Concept> concepts = sessionOne.createQuery( queryOne ).getResultList();
 //       sessionOne.close();
 //       return concepts;
 //   }

    /**
     * Get concept by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of concepts meeting the criteria
     */
 //   public List<Concept> getByPropertyLike(String propertyName, String value) {
//        Session sessionOne = sessionFactoryOne.openSession();
 //       logger.debug("Searching for concept with {} = {}",  propertyName, value);
 //       CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
 //       CriteriaQuery<Concept> queryOne = builderOne.createQuery( Concept.class );
 //       Root<Concept> rootOne = queryOne.from( Concept.class );
 //       Expression<String> propertyPath = rootOne.get(propertyName);
 //       queryOne.where(builderOne.like(propertyPath, "%" + value + "%"));
 //       List<Concept> concepts = sessionOne.createQuery( queryOne ).getResultList();
 //       sessionOne.close();
 //       return concepts;
 //   }

    /**
     * create a concept
     * @param concept  Concept to be created
     * @return id of the created concept
     */
//    public int create(Concept concept) {
 //       int id = 0;
 //       Session sessionOne = sessionFactoryOne.openSession();
  //      Transaction transactionOne = sessionOne.beginTransaction();
  //      id = (int)sessionOne.save(id);
  //      transactionOne.commit();
 //       sessionOne.close();
 //       return id;
 //   }

    /**
     * update a concept
     * @param concept Concept to be updated
     */
 //   public void saveOrUpdate(Concept concept) {
//        Session sessionOne = sessionFactoryOne.openSession();
 //       Transaction transactionOne = sessionOne.beginTransaction();
 //       sessionOne.saveOrUpdate(concept);
 //       transactionOne.commit();
 //       sessionOne.close();
 //   }

    /**
     * Delete a concept
     * @param concept Concept to be deleted
     */
//    public void delete(Concept concept) {
//        Session sessionOne = sessionFactoryOne.openSession();
//        Transaction transactionOne = sessionOne.beginTransaction();
 //       sessionOne.delete(concept);
 //       transactionOne.commit();
 //       sessionOne.close();
 //   }


//}

