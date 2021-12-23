package tn.esprit.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stockmanagement.entity.Produit;
import tn.esprit.stockmanagement.entity.Stock;
import tn.esprit.stockmanagement.repository.ProduitRepository;
import tn.esprit.stockmanagement.repository.StockRepository;

import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 27/11/2021
 * @project IntelliJ IDEA
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public List<Stock> retrieveAllStocks(){
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s){
        return stockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock u){
        return stockRepository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id){
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = produitRepository.getById(idProduit);
        Stock stock = stockRepository.getById(idStock);

        stock.addProduits(produit);
        stockRepository.save(stock);
    }
}
