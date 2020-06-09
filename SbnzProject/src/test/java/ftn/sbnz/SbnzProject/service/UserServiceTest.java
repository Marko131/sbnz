package ftn.sbnz.SbnzProject.service;

import ftn.sbnz.SbnzProject.model.Activity;
import ftn.sbnz.SbnzProject.model.Gender;
import ftn.sbnz.SbnzProject.model.User;
import ftn.sbnz.SbnzProject.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void testCreateUser(){
        User testUser = new User("testuser@gmail.com","testpassword", "Test name", "Test last name", 20, Gender.MALE, 180, 90, Activity.LIGHT);
        Mockito.when(userRepository.findByEmail("testuser@gmail.com")).thenReturn(null);
        Mockito.when(userRepository.save(any(User.class))).thenReturn(testUser);
        User user = userDetailsService.createUser(testUser);

        System.out.println(user.getBodyStatus());
        System.out.println(user.getBmi());
        System.out.println(user.getBmr());
        System.out.println(user.getCalories());

        assertNotNull(user.getBodyStatus());
        assertTrue(user.getBmi() > 0);
        assertTrue(user.getBmr() > 0);
        assertTrue(user.getCalories() > 0);
    }
}
