package com.rcinc.stockmarketsimple.controller;

import com.rcinc.stockmarketsimple.model.Stock;
import com.rcinc.stockmarketsimple.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StockController {

    @Autowired
    StockRepository stockRepository;

/*    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks(@RequestParam (required = false) String ticker){
        try {
            List<Stock> stocks = new ArrayList<Stock>();

            if (ticker == null)
                stockRepository.findAll().forEach(stocks::add);

            if (stocks.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(stocks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

/*    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") long id) {
        Optional<Stock> stockData = stockRepository.findById(id);

        if (stockData.isPresent()) {
            return new ResponseEntity<>(stockData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

/*    @GetMapping("/stocks/{ticker}")
    public ResponseEntity<Stock> getStockByTicker(@PathVariable("ticker") String ticker) {
        Optional<Stock> stockData = stockRepository.findByTicker(ticker);

        if (stockData.isPresent()) {
            return new ResponseEntity<>(stockData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

/*    @GetMapping("/stocks/{name}")
    public ResponseEntity<Stock> getStockByName(@PathVariable("name") String name) {
        Optional<Stock> stockData = stockRepository.findByName(name);

        if (stockData.isPresent()) {
            return new ResponseEntity<>(stockData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

/*    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        try {
            Stock _stock = stockRepository
                    .save(new Stock(stock.getTicker(), stock.getName()));
            return new ResponseEntity<>(_stock, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

/*    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable("id") long id, @RequestBody Stock stock){
        Optional<Stock> stockData = stockRepository.findById(id);

        if(stockData.isPresent()){
            Stock _stock = stockData.get();
            _stock.setTicker(stock.getTicker());
            _stock.setName(stock.getName());
            return new ResponseEntity<>(stockRepository.save(_stock), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

/*    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<HttpStatus> deleteStock(@PathVariable("id") long stock_id) {
        try {
            stockRepository.deleteById(stock_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PostMapping("/quotes")
    public ResponseEntity<Stock> createStockQuote(@RequestBody Stock stockQuote) {
        try {
            Stock _stock = stockRepository
                    .save(new Stock(stockQuote.getTicker(),stockQuote.getName(),stockQuote.getQuarter(),stockQuote.getOpen(), stockQuote.getHigh(), stockQuote.getLow()));
            return new ResponseEntity<>(_stock, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Stock>> getAllQuotes(@RequestParam (required = false) String quarter){
        try {
            List<Stock> stockQuotes = new ArrayList<Stock>();

            if (quarter == null)
                stockRepository.findAll().forEach(stockQuotes::add);

            if (stockQuotes.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(stockQuotes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/quotes/{ticker}")
    public ResponseEntity<List<Stock>> getAllStockByTicker(@PathVariable("ticker") String ticker) {
        //Optional<Stock> stockData = stockRepository.findByTicker(ticker);
        try {
            List<Stock> stockData = stockRepository.findByTicker(ticker);
            //List<Stock> stockQuotes = new ArrayList<Stock>();

            if (ticker == null)
                stockRepository.findAll().forEach(stockData::add);

            if (stockData.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(stockData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/quotes/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable("id") long id, @RequestBody Stock stock){
        Optional<Stock> stockData = stockRepository.findById(id);

        if(stockData.isPresent()){
            Stock _stock = stockData.get();
            _stock.setTicker(stock.getTicker());
            _stock.setName(stock.getName());
            _stock.setQuarter(stock.getQuarter());
            _stock.setOpen(stock.getOpen());
            _stock.setHigh(stock.getHigh());
            _stock.setLow(stock.getLow());
            return new ResponseEntity<>(stockRepository.save(_stock), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/quotes/{id}")
    public ResponseEntity<HttpStatus> deleteStock(@PathVariable("id") long stock_id) {
        try {
            stockRepository.deleteById(stock_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
