package ftn.sbnz.SbnzProject.controller;

import ftn.sbnz.SbnzProject.model.User;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test")
    public String test(){
        return "OK";
    }


    @PostMapping("/testUser")
    public String profile(@RequestBody User user){
        System.out.println(user);

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        kSession.insert(user);
        kSession.fireAllRules();

        System.out.println(user);
        System.out.println("Body Status: " + user.getBodyStatus());
        System.out.println("Calorie: " + user.getCalories());

        return "OK";
    }
}
