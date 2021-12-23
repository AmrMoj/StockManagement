package tn.esprit.stockmanagement.service;

import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.entity.Stock;

import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 27/11/2021
 * @project IntelliJ IDEA
 */
public interface StockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);

    void deleteStock(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);
}
