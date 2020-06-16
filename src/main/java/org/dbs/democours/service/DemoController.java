package org.dbs.democours.service;

import javassist.runtime.Desc;
import org.dbs.democours.business.CmdCreateUtilisateur;
import org.dbs.democours.business.DescUtilisateur;
import org.dbs.democours.business.IDemoUtilisateurService;
import org.dbs.democours.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    IDemoUtilisateurService demoUtilisateurService;

    @GetMapping("/hello/{name}")
    public String getHelloWithParam(@PathVariable("name") String name) {
        return "Hello DBS we receive : "+name;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@RequestBody CmdCreateUtilisateur cmdCreateUtilisateur) {
        System.out.println("Receive : "+ cmdCreateUtilisateur);
        demoUtilisateurService.create(cmdCreateUtilisateur);
    }

    @GetMapping("/findAllByName/{name}")
    public List<DescUtilisateur> retrieveUtilisateursByLastName(@PathVariable("name") String name) {

        return demoUtilisateurService.retrieveUtilisateursByLastName(name);
    }

}
