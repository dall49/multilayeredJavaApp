package inpt.multilayeredapp.springbootdemo.dao;

import inpt.multilayeredapp.springbootdemo.model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.List;

@Repository
public class AuthorDao extends EntityDao<Author, Integer>{

    public Class<Author> entity ;

    public List<Author> findByName(String name){
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = getCriteriaQuery();
        Root<Author> root = criteriaQuery.from(entity);

        EntityType<Author> type = entityManager.getMetamodel().entity(Author.class);

        CriteriaQuery<Author> query = criteriaQuery.select(root).where(
                criteriaBuilder.like(
                        root.get(
                                type.getDeclaredSingularAttribute("name", String.class)),
                        "%" + name + "%")
        );
        return getQuery(query).getResultList();
    }


}
