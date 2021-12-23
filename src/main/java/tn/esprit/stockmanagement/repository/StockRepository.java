package tn.esprit.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stockmanagement.entity.Stock;

/**
 * @author AMR MOUJBANI-PC ON 27/11/2021
 * @project IntelliJ IDEA
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
}
