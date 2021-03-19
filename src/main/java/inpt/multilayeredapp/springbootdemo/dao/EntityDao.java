package inpt.multilayeredapp.springbootdemo.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class EntityDao<T,KEY extends Serializable> {

    // Attributs
    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> entity;


    // Méthodes
    public Optional<T> findByKey(KEY key){
        return Optional.of(entityManager.find(entity,key));
    }

    public List<T> findAll(){
        CriteriaQuery<T>  criteriaQuery = getCriteriaQuery();
        Root<T> root = criteriaQuery.from(entity);
        TypedQuery<T> resultQuery = getQuery(criteriaQuery.select(root));

        return resultQuery.getResultList();

    }

    public T create(T entity){
        entityManager.persist(entity);
        return entity;
    }

    public T update(T entity){
        return entityManager.merge(entity);
    }

    public T delete(T entity){
        entityManager.remove(entity);
        return entity;
    }


    // méthodes auxiliaires

    protected CriteriaBuilder getCriteriaBuilder(){
        return entityManager.getCriteriaBuilder();
    }

    protected CriteriaQuery<T> getCriteriaQuery(){
        return entityManager.getCriteriaBuilder().createQuery(entity);
    }

    protected TypedQuery<T> getQuery(CriteriaQuery<T> criteriaQuery){
        return entityManager.createQuery(criteriaQuery);
    }


}
