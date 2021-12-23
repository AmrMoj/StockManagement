package tn.esprit.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.stockmanagement.entity.Facture;

import java.util.List;


/**
 * @author AMR MOUJBANI-PC ON 28/11/2021
 * @project IntelliJ IDEA
 */
public interface FactureRepository extends JpaRepository<Facture, Long> {

    @Query("select f from Facture f join f.client c where c.idClient = :idClient")
    List<Facture> getFacturesByClient(@Param("idClient") Long idClient);
}
