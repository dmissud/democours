package org.dbs.democours.business;

import java.util.List;

public interface IDemoUtilisateurService {
    void create(CmdCreateUtilisateur cmdCreateUtilisateur);

    List<DescUtilisateur> retrieveUtilisateursByLastName(String name);

    void changeFirstNameUtilisateur(CmdChangeFirstName cmdChangeFirstName);
}
