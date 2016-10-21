package services.impl;

import org.junit.Test;
import persistence.entities.User;

import static org.junit.Assert.*;

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