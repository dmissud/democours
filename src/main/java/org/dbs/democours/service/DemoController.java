package org.dbs.democours.service;

import org.dbs.democours.business.CmdChangeFirstName;
import org.dbs.democours.business.CmdCreateUtilisateur;
import org.dbs.democours.business.DescUtilisateur;
import org.dbs.democours.business.IDemoUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    public static final String RECEIVE = "Receive : ";
    @Autowired
    IDemoUtilisateurService demoUtilisateurService;

    @GetMapping("/hello/{name}")
    public String getHelloWithParam(@PathVariable("name") String name) {
        return "Hello DBS we receive : " + name;
    }

    @GetMapping("/findAllByName/{name}")
    public List<DescUtilisateur> retrieveUtilisateursByLastName(@PathVariable("name") String name) {

        return demoUtilisateurService.retrieveUtilisateursByLastName(name);
    }

    /*
     * le json exemple {"firstName":"Eric","lastName":"Burp"}
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@RequestBody CmdCreateUtilisateur cmdCreateUtilisateur) {
        if (cmdCreateUtilisateur.isValid()) {
            System.out.println(RECEIVE + cmdCreateUtilisateur);
            demoUtilisateurService.create(cmdCreateUtilisateur);
        } else {
            System.out.println(RECEIVE+" invalide cmd " + cmdCreateUtilisateur);
        }
    }

    /*
     * le json exemple {"lastName":"Burp", "oldFirstName":"Eric","newFirstName":"Boby"}
     */
    @PostMapping("/changeFirstname")
    public void changeFirstNameUtilisateurs(@RequestBody CmdChangeFirstName cmdChangeFirstName) {
        System.out.println(RECEIVE + cmdChangeFirstName);
        if (cmdChangeFirstName.isValid()) {
            System.out.println(RECEIVE + cmdChangeFirstName);
            demoUtilisateurService.changeFirstNameUtilisateur(cmdChangeFirstName);
        } else {
            System.out.println(RECEIVE+" invalide cmd " + cmdChangeFirstName);
        }
    }

}
