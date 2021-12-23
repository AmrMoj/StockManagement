package tn.esprit.stockmanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.controller.exception.NoDataFoundException;
import tn.esprit.stockmanagement.entity.CategorieClient;
import tn.esprit.stockmanagement.entity.Client;
import tn.esprit.stockmanagement.repository.ClientRepository;

import java.util.Date;
import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 27/11/2021
 * @project IntelliJ IDEA
 */
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> retrieveAllClients(){
        List<Client> clientList= clientRepository.findAll();
        for (Client cl: clientList){
            log.info("Client: "+cl);
        }
        return clientList;
    }

    @Override
    public Client addClient(Client c) {
        log.info("Adding Client: "+ c.getPrenom() + " "+ c.getNom());
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id){
        Client client=clientRepository.findById(id).orElse(null);
        log.info("Deleting client: "+client.getPrenom() + " " +client.getNom());
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c){
        log.info("Updating a client: "+c);

        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id){
        
        return clientRepository.findById(id).orElseThrow(NoDataFoundException::new);

    }

    @Override
    public List<Client> clientNéeEntreDeuxDate(Date firstDate, Date secondDate) {
        log.info("Getting clients born between date: "+firstDate+"and: "+secondDate);
        return clientRepository.clientNéeEntreDeuxDate(firstDate, secondDate);
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        log.info("Getting chiffre d'affaire par categorie client: ");
        return clientRepository.getChiffreAffaireParCategorieClient(categorieClient,startDate,endDate);
    }

}
