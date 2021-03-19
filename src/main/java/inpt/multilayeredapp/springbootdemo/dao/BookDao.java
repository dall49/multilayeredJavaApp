package inpt.multilayeredapp.springbootdemo.dao;

import inpt.multilayeredapp.springbootdemo.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.List;


@Repository
public class BookDao extends EntityDao<Book, Integer>{

    public Class<Book> entity ;

    public List<Book> findByTitle(String title){
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = getCriteriaQuery();
        Root<Book> root = criteriaQuery.from(entity);

        EntityType<Book> type = entityManager.getMetamodel().entity(Book.class);

        CriteriaQuery<Book> query = criteriaQuery.select(root).where(
                criteriaBuilder.like(
                        root.get(
                                type.getDeclaredSingularAttribute("title", String.class)),
                        "%" + title + "%")
        );
        return getQuery(query).getResultList();
    }

}
