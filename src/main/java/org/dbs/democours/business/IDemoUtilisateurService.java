package org.dbs.democours.business;

import org.dbs.democours.entity.Utilisateur;

import java.util.List;

public interface IDemoUtilisateurService {
    void create(CmdCreateUtilisateur cmdCreateUtilisateur);

    List<DescUtilisateur> retrieveUtilisateursByLastName(String name);
}
