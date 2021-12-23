package tn.esprit.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.repository.DetailFactureRepository;

import java.util.Date;

/**
 * @author AMR MOUJBANI-PC ON 22/12/2021
 * @project IntelliJ IDEA
 */
@Service
public class DetailFactureServiceImpl implements DetailFactureService{

    @Autowired
    DetailFactureRepository detailFactureRepository;

    /*@Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        return detailFactureRepository.getRevenuBrutProduit(idProduit,startDate,endDate);
    }*/
}
