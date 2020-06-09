package ftn.sbnz.SbnzProject.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final KieSession kieSession;

    @Autowired
    public SessionService(KieContainer kieContainer){
        this.kieSession = kieContainer.newKieSession("meal-session");
    }

    public KieSession getKieSession() {
        return kieSession;
    }

}
