package com.rcinc.stockmarketsimple.repository;

import com.rcinc.stockmarketsimple.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByTicker(String ticker);
    Optional<Stock> findByName(String name);
}
