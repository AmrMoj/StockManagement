package tn.esprit.stockmanagement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stockmanagement.entity.CategorieProduit;
import tn.esprit.stockmanagement.entity.Produit;
import tn.esprit.stockmanagement.service.ProduitService;

import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 18/12/2021
 * @project IntelliJ IDEA
 */
@RestController
@RequestMapping("produit")
@Api(tags = "Product management")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

    @ApiOperation("Add product")
    @PostMapping("addProduit/{idRayon}/{idStock}/{categorieProduit}")
    public Produit addProduit(@RequestBody Produit p,@PathVariable Long idRayon,@PathVariable Long idStock,@PathVariable CategorieProduit categorieProduit){
        return produitService.addProduit(p,idRayon,idStock,categorieProduit);
    }

    @ApiOperation("Get all products")
    @GetMapping("getAll")
    public List<Produit> retrieveAllProduits(){
        return produitService.retrieveAllProduits();
    }

    @ApiOperation("Get product by Id")
    @GetMapping("getProduit/{id-produit")
    public Produit getProduit(@PathVariable("id-produit") long idProduit){
        return produitService.retrieveProduit(idProduit);
    }

    @ApiOperation("Assign provider to product")
    @PostMapping("assignFournisseurToProduit/{id-fournisseur}/{id-produit}")
    public void assignFournisseurToProduit(@PathVariable("id-fournisseur") Long fournisseurId,@PathVariable("id-produit") Long produitId){
        produitService.assignFournisseurToProduit(fournisseurId,produitId);
    }
}
