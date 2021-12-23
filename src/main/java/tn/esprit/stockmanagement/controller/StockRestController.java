package tn.esprit.stockmanagement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stockmanagement.entity.Client;
import tn.esprit.stockmanagement.entity.Stock;
import tn.esprit.stockmanagement.service.StockService;

import java.util.Date;
import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 18/12/2021
 * @project IntelliJ IDEA
 */
@RestController
@RequestMapping("stock")
@Api(tags = "Stock management")
public class StockRestController {

    @Autowired
    StockService stockService;

    @ApiOperation(value="Add stock")
    @PostMapping("addStock")
    public Stock addStock(@RequestBody Stock stock){
        return stockService.addStock(stock);
    }

    @ApiOperation(value = "Get stocks")
    @GetMapping("getAll")
    public List<Stock> retrieveAllStock(){
        return stockService.retrieveAllStocks();
    }

    @ApiOperation(value = "Get a stock")
    @GetMapping("getStock/{stock-id}")
    public Stock retrieveStock(@PathVariable("stock-id") long id){
        return stockService.retrieveStock(id);
    }

    @ApiOperation(value = "Delete stock")
    @DeleteMapping("deleteStock/{stock-id}")
    public void deleteClient(@PathVariable("stock-id") long id){
        stockService.deleteStock(id);
    }

    @ApiOperation(value = "Update a stock")
    @PutMapping("updateStock")
    public Stock updateStock(@RequestBody Stock stock){
        return stockService.updateStock(stock);
    }

    @ApiOperation(value = "Assign Product to Stock")
    @PostMapping("assignProdStock/{id-product}/{id-stock}")
    public void assignProdStock(@PathVariable("id-product") long idProduit, @PathVariable("id-stock") long idStock){
        stockService.assignProduitToStock(idProduit, idStock);
    }
}
