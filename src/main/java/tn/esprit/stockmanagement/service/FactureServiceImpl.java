package tn.esprit.stockmanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.entity.Client;
import tn.esprit.stockmanagement.entity.Facture;
import tn.esprit.stockmanagement.repository.ClientRepository;
import tn.esprit.stockmanagement.repository.FactureRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 28/11/2021
 * @project IntelliJ IDEA
 */
@Slf4j
@Service
public class FactureServiceImpl implements FactureService{

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture= factureRepository.findById(id).get();
        facture.setActive(false);
        factureRepository.save(facture);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(id).get();
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        return factureRepository.getFacturesByClient(idClient);
    }

    @Transactional
    @Override
    public Facture addFacture(Facture f, long idClient) {
        Client c = clientRepository.findById(idClient).get();
        f.setClient(c);
        log.info("Adding Facture attached to client: "+ c.getPrenom() + " "+ c.getNom());
        return factureRepository.save(f);
    }
}
