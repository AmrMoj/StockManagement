package tn.esprit.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stockmanagement.entity.Produit;

/**
 * @author AMR MOUJBANI-PC ON 28/11/2021
 * @project IntelliJ IDEA
 */
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
