package tn.esprit.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.stockmanagement.entity.CategorieClient;
import tn.esprit.stockmanagement.entity.Client;

import java.util.Date;
import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 27/11/2021
 * @project IntelliJ IDEA
 */
@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

    @Query("select sum (f.montantFacture) from Facture f join f.client c where c.categorieClient=:categorieClient " +
            "and f.dateFacture BETWEEN :startDate and :endDate ")
    public float getChiffreAffaireParCategorieClient(@Param("categorieClient") CategorieClient categorieClient, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select c from Client c where c.dateNaissance between :firstDate and :secondDate" )
    public List<Client> clientNéeEntreDeuxDate(@Param("firstDate") Date firstDate,@Param("secondDate") Date secondDate);

}