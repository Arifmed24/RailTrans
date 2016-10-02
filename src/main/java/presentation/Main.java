package presentation;

import persistence.dao.impl.PassengerDaoImpl;
import persistence.dao.impl.UserDaoImpl;
import persistence.entities.Passenger;
import persistence.entities.RoleEnum;
import persistence.entities.User;


import java.util.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public class Main {

    public static void main(String[] args) throws SQLException {

//        PassengerDaoImpl passengerDao = new PassengerDaoImpl();
//        Passenger passenger = new Passenger();
//        passenger.setFirstName("FirstName");
//        passenger.setLastName("LastName");
//        passenger.setBirth(new Date());
//
//        Passenger passenger1 = new Passenger();
//        passenger1.setFirstName("FirstName1");
//        passenger1.setLastName("LastName1");
//        passenger1.setBirth(new Date());
//
//        Passenger passenger11 = passengerDao.create(passenger);
//        Passenger passenger2 = passengerDao.create(passenger1);
//
//        System.out.println(passenger11.getIdPassenger());
//        System.out.println(passenger2.getIdPassenger());
//
//        Passenger read = passengerDao.read(passenger11.getIdPassenger());

//        User user1 = new User();
//        user1.setLogin("admin");
//        user1.setPassword("qwerty123");
//        user1.setRole(RoleEnum.ADMIN);
//        UserDaoImpl userDao = new UserDaoImpl();
//        User user11 = userDao.create(user1);
//        System.out.println(userDao.findByLogin("admin"));
    }
}
