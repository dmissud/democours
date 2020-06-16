package org.dbs.democours.dao;

import org.dbs.democours.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDaoUtilisateur extends JpaRepository<Utilisateur, Long> {

    List<Utilisateur> findByLastName(String lastName);

}
