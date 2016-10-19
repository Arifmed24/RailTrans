package services.impl;

import org.junit.Before;
import org.junit.Test;
import persistence.dao.api.UserDao;
import persistence.dao.impl.UserDaoImpl;
import persistence.entities.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by abalaev on 18.10.2016.
 */
public class UserServiceImplTest {

    @Test
    public void findUserByLogin() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        User u =

                 userService.findUserByLogin("admin");
        assertEquals("Arif Balaev", u.getFio());
    }


}