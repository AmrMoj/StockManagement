package tn.esprit.stockmanagement;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.stockmanagement.entity.Stock;
import tn.esprit.stockmanagement.service.StockService;

import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 22/12/2021
 * @project IntelliJ IDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

    @Autowired
    StockService stockService;

    @Test
    public void testAddStock() {
        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected = stocks.size();
        Stock s = new Stock();
        s.setLibelleStock("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock savedStock = stockService.addStock(s);
        Assert.assertEquals(expected + 1, stockService.retrieveAllStocks().size());

        stockService.deleteStock(savedStock.getIdStock());
    }
}
