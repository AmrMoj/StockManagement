package tn.esprit.stockmanagement.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stockmanagement.entity.Facture;
import tn.esprit.stockmanagement.service.FactureService;

import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 19/12/2021
 * @project IntelliJ IDEA
 */
@RestController
@RequestMapping("facture")
@ApiOperation("Facture Management")
public class FactureRestController {

    @Autowired
    FactureService factureService;

    @ApiOperation(value = "Get factures")
    @GetMapping("/getAll")
    public List<Facture> retrieveAllFacture(){
        return factureService.retrieveAllFactures();
    }

    @ApiOperation(value = "Get a facture")
    @GetMapping("/getFacture/{id-facture}")
    public Facture getFacture(@PathVariable("id-facture") long id){
        return factureService.retrieveFacture(id);
    }

    @ApiOperation(value = "Cancel facture")
    @PutMapping("/cancelFacture/{id-facture}")
    public void canceFacture(@PathVariable("id-facture") long id){
        factureService.cancelFacture(id);
    }

    @ApiOperation(value = "Get facture by Client")
    @GetMapping("/getFactureByClient/{id-client}")
    public List<Facture> getFactureByClient(@PathVariable("id-client") long idClient){
        return factureService.getFacturesByClient(idClient);
    }

    @ApiOperation(value = "Add facture")
    @PostMapping("/addFacture/{client-id}")
    public Facture addFacture(@RequestBody Facture facture, @PathVariable("client-id") long id){
        return factureService.addFacture(facture,id);
    }
}
