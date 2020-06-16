package org.dbs.democours.dao;

import org.dbs.democours.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDaoUtilisateur extends CrudRepository <Utilisateur, Long> {

    List<Utilisateur> findByLastName(String lastName);

}
