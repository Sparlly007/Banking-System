package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import AccountCreation.Components;
import AccountCreation.Signin;
import AccountEntity.Balance;
import AccountEntity.User;
import Service.Service;

public class Test {
    User user;
    Service service;

    @org.junit.Test
    public void accountCreationTest(){
        //assertNotEquals(2, 1);
        user = new User("Emeka", "emekankuku@gmail.com", "password");
        assertEquals("Emeka", user.getName());
        assertEquals("password", user.getPassword());
        assertEquals("emekankuku@gmail.com", user.getEmail());

    }    

    @org.junit.Test
    public void serviceTest(){
        String pw = "lanique19";
        User user0 = new User("Ragnarok", "ragnarok@gmail.com", pw, new Balance(500, 150));
        service = new Service();
        service.register(user0);
        assertEquals(user0.getName(), service.getUser(pw).getName());
        service.deleteUser(user0);
        assertNull(service.getUser(pw));
        
    }  

    @org.junit.Test
    public void bankingTest(){
        user = new User("Ragnarok", "ragnarok@gmail.com", "password", new Balance(500, 150));
        assertEquals(500, user.getSBalance(),0.01);
        assertEquals(150, user.getCBalance(),0.01);
        user.depositToChecking(11.1);
        user.depositToSavings(643.0);
        assertEquals(161.1, user.getCBalance(), 0.01);
        assertEquals(1143, user.getSBalance(), 0.01);
        user.withdrawFromChecking(100.0);
        user.withdrawFromSavings(1000.0);
        assertEquals(61.1, user.getCBalance(), 0.01);
        assertEquals(143, user.getSBalance(), 0.01);
    }
}
