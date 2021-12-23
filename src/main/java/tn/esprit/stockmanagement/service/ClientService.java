package tn.esprit.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.entity.CategorieClient;
import tn.esprit.stockmanagement.entity.Client;
import tn.esprit.stockmanagement.repository.ClientRepository;

import java.util.Date;
import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 27/11/2021
 * @project IntelliJ IDEA
 */

public interface ClientService {
    List<Client> retrieveAllClients();

    Client addClient(Client c);

    void deleteClient(Long id);

    Client updateClient(Client c);

    Client retrieveClient(Long id);

    List<Client> clientNéeEntreDeuxDate(Date firstDate, Date secondDate);

    float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);



}
