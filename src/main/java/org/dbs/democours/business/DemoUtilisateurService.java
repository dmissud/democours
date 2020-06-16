package org.dbs.democours.business;

import org.dbs.democours.dao.IDaoUtilisateur;
import org.dbs.democours.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void changeFirstNameUtilisateur(CmdChangeFirstName cmdChangeFirstName) {
        List<Utilisateur> utilisateurs = daoUtilisateur.findByLastName(cmdChangeFirstName.getLastName());
        Utilisateur utilisateurExistant = findUtilisateurByFirstName(utilisateurs, cmdChangeFirstName.getNewFirstName());
        if (utilisateurExistant == null) {
            Utilisateur aUtilisateur = findUtilisateurByFirstName(utilisateurs, cmdChangeFirstName.getOldFirstName());
            if (aUtilisateur != null) {
                aUtilisateur.setFirstName(cmdChangeFirstName.getNewFirstName());
                daoUtilisateur.save(aUtilisateur);
                System.out.println(cmdChangeFirstName + " ok");
            } else {
                System.out.println(cmdChangeFirstName + " porte sur un utilisateur qui existe pas : cmd impossible");
            }
        } else {
            System.out.println(utilisateurExistant + " existe déjà : cmd impossible");
        }
    }

    private Utilisateur findUtilisateurByFirstName(List<Utilisateur> utilisateurs, String firstName) {
        Utilisateur aUtilisateur = null;
        for(Utilisateur utilisateur: utilisateurs) {
            if (utilisateur.getFirstName().equals(firstName)) {
                aUtilisateur = utilisateur;
            }
        }
        return aUtilisateur;
    }

    private void createUtilisateurFromCmd(CmdCreateUtilisateur cmdCreateUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setFirstName(cmdCreateUtilisateur.getFirstName());
        utilisateur.setLastName(cmdCreateUtilisateur.getLastName());
        daoUtilisateur.save(utilisateur);
        System.out.println("Creation de : " + utilisateur);
    }
}
