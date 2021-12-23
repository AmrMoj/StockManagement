package tn.esprit.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.entity.*;
import tn.esprit.stockmanagement.repository.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 28/11/2021
 * @project IntelliJ IDEA
 */
@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    RayonRepository rayonRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    DetailProduitRepository detailProduitRepository;

    @Autowired
    FournisseurRepository fournisseurRepository;

    @Override
    public List<Produit> retrieveAllProduits() {

        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock, CategorieProduit categorieProduit) {

        DetailProduit detailProduit = new DetailProduit();
        detailProduit.setDateCreation(new java.util.Date());
        detailProduit.setDateDerniereModification(new java.util.Date());
        detailProduit.setCategorieProduit(categorieProduit);

        p.setDetailProduit(detailProduit);

        Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
        Stock stock = stockRepository.findById(idStock).orElse(null);
        if (stock!= null)  p.setStock(stock);
        if (rayon!=null) p.setRayon(rayon);

        return produitRepository.save(p);

    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {

        Produit produit = produitRepository.findById(produitId).get();
        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).get();

        produit.addFournisseur(fournisseur);
        produitRepository.save(produit);

    }


}
