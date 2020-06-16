package org.dbs.democours.business;

import org.dbs.democours.dao.IDaoUtilisateur;
import org.dbs.democours.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoUtilisateurService implements IDemoUtilisateurService {
    @Autowired
    IDaoUtilisateur daoUtilisateur;

    public void create(CmdCreateUtilisateur cmdCreateUtilisateur) {
        List<Utilisateur> utilisateurs = daoUtilisateur.findByLastName(cmdCreateUtilisateur.getLastName());

        if (utilisateurs.isEmpty()) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setFirstName(cmdCreateUtilisateur.getFirstName());
            utilisateur.setLastName(cmdCreateUtilisateur.getLastName());
            daoUtilisateur.save(utilisateur);
            System.out.println("Creation de : " + utilisateur);
        } else {
            utilisateurs.forEach(utilisateur -> {
                System.out.println("Impossible de créer car déja existant de : " + utilisateur);
            });
        }
    }
}
