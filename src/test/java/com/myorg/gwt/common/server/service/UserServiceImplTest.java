package com.myorg.gwt.common.server.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.myorg.gwt.common.server.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class UserServiceImplTest {

    private static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    UserService userService;

    @Test
    public void checkUserByLogin() throws ParseException {
        User user = userService.getUserByLogin("john");
        Assert.assertEquals("john", user.getLogin());
        Assert.assertEquals("John", user.getFirstName());
        Assert.assertEquals("Looters", user.getLastName());

        Date expectedDate = dateFormater.parse("1976-02-05");
        Assert.assertEquals(expectedDate, user.getBirthday());
        Assert.assertEquals("looters.john@gmail.com", user.getEmail());
    }

    @Test
    @DatabaseSetup("/data/setupUsersData.xml")
    @DatabaseTearDown("/data/tearDownUsersData.xml")
    public void checkUsersSortedByBirthday() throws ParseException {
        List<User> sortedUsers = userService.getUsersSortedByBirthday();
        Assert.assertEquals(5, sortedUsers.size());
        Assert.assertEquals(dateFormater.parse("1985-02-05"), sortedUsers.get(0).getBirthday());
        Assert.assertEquals(dateFormater.parse("1986-02-05"), sortedUsers.get(1).getBirthday());
        Assert.assertEquals(dateFormater.parse("1986-02-05"), sortedUsers.get(2).getBirthday());
        Assert.assertEquals(dateFormater.parse("1987-02-05"), sortedUsers.get(3).getBirthday());
        Assert.assertEquals(dateFormater.parse("1988-02-05"), sortedUsers.get(4).getBirthday());
    }
}
