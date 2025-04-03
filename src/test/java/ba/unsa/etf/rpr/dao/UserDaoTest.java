package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {
    @Test
    void GetterAndSetterTest() {
        User u=new User();
        u.setId(5);
        u.setPassword("pass");
        u.setEmail("email");
        u.setUsername("name");

        assertEquals(u.getId(),5);
        assertEquals(u.getUsername(),"name");
        assertEquals(u.getPassword(),"pass");
        assertEquals(u.getEmail(),"email");
    }

    @Test
    void EqualsTest() {
        User u1=new User(1,"123","pass","user");
        User u2=new User(1,"123","pass","user");
        assertEquals(u1,u2);
    }

    @Test
    void ToStringTest() {
        User u=new User(1,"123","pass","user");
        assertEquals(u.toString(),"User{userid=1, username='123', email='pass', password='user'}");
    }
}
