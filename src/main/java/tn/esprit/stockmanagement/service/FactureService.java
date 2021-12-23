package tn.esprit.stockmanagement.service;

import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.entity.Facture;

import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 28/11/2021
 * @project IntelliJ IDEA
 */

public interface FactureService {

    List <Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
    List<Facture> getFacturesByClient(Long idClient);
    Facture addFacture(Facture f, long idClient);
    

}
