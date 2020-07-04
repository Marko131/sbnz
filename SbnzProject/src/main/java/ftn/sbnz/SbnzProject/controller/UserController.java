package ftn.sbnz.SbnzProject.controller;

import ftn.sbnz.SbnzProject.dto.*;
import ftn.sbnz.SbnzProject.exceptions.PasswordsDoNotMatchException;
import ftn.sbnz.SbnzProject.model.User;
import ftn.sbnz.SbnzProject.security.TokenUtils;
import ftn.sbnz.SbnzProject.service.MealService;
import ftn.sbnz.SbnzProject.service.UserDetailsServiceImpl;
import org.apache.maven.shared.invoker.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MealService mealService;

    @Autowired
    TokenUtils tokenUtils;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginUserDTO loginUserDTO) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    loginUserDTO.getEmail(), loginUserDTO.getPassword());
            authenticationManager.authenticate(token);
            UserDetails details = userDetailsService.loadUserByUsername(loginUserDTO.getEmail());
            return new ResponseEntity<String>(tokenUtils.generateToken(details), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Invalid login", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterUserDTO registerUserDTO) {
        if (!registerUserDTO.getPassword1().equals(registerUserDTO.getPassword2())) throw new PasswordsDoNotMatchException();
        User user = new User(
                registerUserDTO.getEmail(),
                registerUserDTO.getPassword1(),
                registerUserDTO.getFirstName(),
                registerUserDTO.getLastName(),
                registerUserDTO.getAge(),
                registerUserDTO.getGender(),
                registerUserDTO.getHeight(),
                registerUserDTO.getWeight(),
                registerUserDTO.getActivity());
        userDetailsService.createUser(user);
        return new ResponseEntity<String>("User successfully created", HttpStatus.CREATED);
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserProfileDTO> profile(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.findUserByEmail(email);
        //Day day = mealService.getDay(user);

        UserProfileDTO userProfileDTO = new UserProfileDTO(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getGender(),
                user.getHeight(),
                user.getWeight(),
                user.getBmi(),
                user.getBodyStatus(),
                user.getBmr(),
                user.getCalories(),
                user.getActivity()
        );
        return new ResponseEntity<UserProfileDTO>(userProfileDTO, HttpStatus.OK);
    }

    @PostMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserProfileDTO> updateProfile(@Valid @RequestBody UpdateProfileDTO updateProfileDTO) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDetailsService.findUserByEmail(email);

        user.setAge(updateProfileDTO.getAge());
        user.setHeight(updateProfileDTO.getHeight());
        user.setWeight(updateProfileDTO.getWeight());
        user.setActivity(updateProfileDTO.getActivity());

        User updated = userDetailsService.updateProfile(user);

        UserProfileDTO userProfileDTO = new UserProfileDTO(
                updated.getEmail(),
                updated.getFirstName(),
                updated.getLastName(),
                updated.getAge(),
                updated.getGender(),
                updated.getHeight(),
                updated.getWeight(),
                updated.getBmi(),
                updated.getBodyStatus(),
                updated.getBmr(),
                updated.getCalories(),
                updated.getActivity()
        );
        return new ResponseEntity<>(userProfileDTO, HttpStatus.OK);
    }



    @PostMapping("/drl")
    public void addDrl(@RequestBody DroolsDTO droolsDTO) throws FileNotFoundException, MavenInvocationException {
        String path = "..\\drools-spring-kjar\\src\\main\\resources\\sbnz\\integracija\\" + droolsDTO.getFileName() + ".drl";
        PrintWriter out = new PrintWriter(new File(path));
        out.println(droolsDTO.getText());
        out.close();
        cleanInstall();
    }

    private void cleanInstall () throws RuntimeException, MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "..\\drools-spring-kjar\\pom.xml" ) );
        ArrayList<String> goals = new ArrayList<String>();
        goals.add("clean");
        goals.add("install");
        request.setGoals(goals);
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("M2_HOME")));
        invoker.execute( request );
    }

}
