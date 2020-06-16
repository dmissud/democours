package org.dbs.democours.business;

import org.dbs.democours.dao.IDaoUtilisateur;
import org.dbs.democours.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DemoUtilisateurService implements IDemoUtilisateurService {
    @Autowired
    IDaoUtilisateur daoUtilisateur;

    public void create(CmdCreateUtilisateur cmdCreateUtilisateur) {
        List<Utilisateur> utilisateurs = daoUtilisateur.findByLastName(cmdCreateUtilisateur.getLastName());

        boolean isExistant = false;
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getFirstName().equals(cmdCreateUtilisateur.getFirstName())) {
                System.out.println("Impossible de créer car déja existant de : " + utilisateur);
                isExistant = true;
            }
        }
        if (!isExistant) {
            createUtilisateurFromCmd(cmdCreateUtilisateur);
        }
    }

    @Override
    public List<DescUtilisateur> retrieveUtilisateursByLastName(String name) {
        List<Utilisateur> utilisateurs = daoUtilisateur.findByLastName(name);
        List<DescUtilisateur> descUtilisateurs = new ArrayList<>();
        int nbMemberInFamily = utilisateurs.size();
        int orderInFamily = 1;
        for (Utilisateur utilisateur : utilisateurs) {
            DescUtilisateur descUtilisateur = new DescUtilisateur();
            descUtilisateur.setFistName(utilisateur.getFirstName());
            descUtilisateur.setLastName(utilisateur.getLastName());
            descUtilisateur.setMemberInFamilly(nbMemberInFamily);
            descUtilisateur.setOrderInFamilly(orderInFamily++);
            descUtilisateurs.add(descUtilisateur);
            System.out.println(descUtilisateur);
        }

        return descUtilisateurs;
    }

    private void createUtilisateurFromCmd(CmdCreateUtilisateur cmdCreateUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setFirstName(cmdCreateUtilisateur.getFirstName());
        utilisateur.setLastName(cmdCreateUtilisateur.getLastName());
        daoUtilisateur.save(utilisateur);
        System.out.println("Creation de : " + utilisateur);
    }
}
