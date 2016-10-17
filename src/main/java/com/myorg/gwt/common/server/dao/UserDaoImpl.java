package com.myorg.gwt.common.server.dao;

import com.myorg.gwt.common.server.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByLogin(String login) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user);
        criteriaQuery.where(builder.equal(user.get("login"), login));
        TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);

        return typedQuery.getSingleResult();
    }

    @Override
    public List<User> getUsersSortedByBirthday() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user);
        criteriaQuery.orderBy(builder.asc(user.get("birthday")));
        TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }
}