package tn.esprit.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.stockmanagement.entity.DetailFacture;

import java.util.Date;

/**
 * @author AMR MOUJBANI-PC ON 22/12/2021
 * @project IntelliJ IDEA
 */
public interface DetailFactureRepository extends JpaRepository<DetailFacture, Long> {
    //@Query("select df.qte * p.prixUnitaire from DetailFacture df join df.produit p  where p.idProduit= :idProduit and Facture.dateFacture between :startDate and :endDate")
    //
    // float getRevenuBrutProduit(@Param("idProduit") Long idProduit,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}
