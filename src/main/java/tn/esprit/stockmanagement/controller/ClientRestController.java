package tn.esprit.stockmanagement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stockmanagement.entity.CategorieClient;
import tn.esprit.stockmanagement.entity.Client;
import tn.esprit.stockmanagement.service.ClientService;

import java.util.Date;
import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 11/12/2021
 * @project IntelliJ IDEA
 */
@RestController
@RequestMapping("client")
@Api(tags = "Client management")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @ApiOperation(value="Add new client")
    @PostMapping("addClient")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @ApiOperation(value = "Get all clients")
    @GetMapping("getAll")
    public List<Client> retrieveAllClients(){
        return clientService.retrieveAllClients();
    }

    @ApiOperation(value = "Get a client")
    @GetMapping("getClient/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") long id){
        return clientService.retrieveClient(id);
    }

    @ApiOperation(value = "Delete a client")
    @DeleteMapping("deleteClient/{client-id}")
    public void deleteClient(@PathVariable("client-id") long id){
        clientService.deleteClient(id);
    }

    @ApiOperation(value = "Update a client")
    @PutMapping("updateClient")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @ApiOperation(value = "Retrieve clients with birth date between")
    @GetMapping("getClientBirthdateBetween/{firstDate}/{secondDate}")
    public List<Client> getClientsBirthdateBetweenTwo(@PathVariable("firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate, @PathVariable("secondDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date secondDate){
        return clientService.clientNéeEntreDeuxDate(firstDate,secondDate);
    }

    @ApiOperation(value = "Retrieve chiffre d'affaire par catégorie client")
    @GetMapping("getChiffreAffaireParCategorieClient/{categorie-client}/{start-date}/{end-date}")
    public float getChiffreAffaireParCategorieClient (@PathVariable("categorie-client")CategorieClient categorieClient, @PathVariable("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable("end-date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return clientService.getChiffreAffaireParCategorieClient(categorieClient,startDate,endDate);
    }

}
