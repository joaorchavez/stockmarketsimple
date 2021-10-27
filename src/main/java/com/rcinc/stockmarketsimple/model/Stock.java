package com.rcinc.stockmarketsimple.model;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
@SecondaryTable(name = "quotes", pkJoinColumns = @PrimaryKeyJoinColumn(name = "stock_id"))
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name")
    private String name;

    @Column(name = "quarter", table = "quotes")
    private int quarter;

    @Column(name = "open", table = "quotes")
    private long open;

    @Column(name = "high", table = "quotes")
    private long high;

    @Column(name = "low", table = "quotes")
    private long low;

    public Stock() {
    }

    public Stock(String ticker, String name) {
        this.ticker = ticker;
        this.name = name;

    }

    public Stock(String ticker, String name, int quarter, long open, long high, long low) {
        this.ticker = ticker;
        this.name = name;
        this.quarter = quarter;
        this.open = open;
        this.high = high;
        this.low = low;
    }

    public long getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public long getOpen() {
        return open;
    }

    public void setOpen(long open) {
        this.open = open;
    }

    public long getHigh() {
        return high;
    }

    public void setHigh(long high) {
        this.high = high;
    }

    public long getLow() {
        return low;
    }

    public void setLow(long low) {
        this.low = low;
    }
}
