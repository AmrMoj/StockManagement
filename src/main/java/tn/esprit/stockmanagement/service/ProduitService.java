package tn.esprit.stockmanagement.service;

import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.entity.CategorieProduit;
import tn.esprit.stockmanagement.entity.Produit;

import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 28/11/2021
 * @project IntelliJ IDEA
 */
public interface ProduitService {
    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock, CategorieProduit categorieProduit);

    Produit retrieveProduit(Long id);

    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
}
