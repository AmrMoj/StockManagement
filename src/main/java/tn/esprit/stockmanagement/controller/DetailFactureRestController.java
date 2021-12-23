package tn.esprit.stockmanagement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.stockmanagement.service.DetailFactureService;

import java.util.Date;

/**
 * @author AMR MOUJBANI-PC ON 22/12/2021
 * @project IntelliJ IDEA
 */
@RestController
@RequestMapping("/detailFacture")
public class DetailFactureRestController {

    @Autowired
    DetailFactureService detailFactureService;

    /*@ApiOperation("Get revenue brut par produit")
    @GetMapping("/getRevenueBrutProduit/{produit-id}/{startDate}/{endDate}")
    public float getRevenueBrutProduit(@PathVariable("produit-id") long idProduit, @PathVariable("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable("end-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return detailFactureService.getRevenuBrutProduit(idProduit,startDate,endDate);
    }*/
}
