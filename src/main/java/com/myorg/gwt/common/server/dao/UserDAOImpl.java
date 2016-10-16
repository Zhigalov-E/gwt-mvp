package com.myorg.gwt.common.server.dao;

import com.myorg.gwt.common.server.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> getUsersSortedByBirthday() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.addOrder(Order.asc("birthday"));
        return (List<User>) criteria.list();
    }
}