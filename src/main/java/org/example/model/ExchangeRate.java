package org.example.model;



import jakarta.persistence.*;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;
    private double rateToUah;

    public ExchangeRate() {}

    public ExchangeRate(String currency, double rateToUah) {
        this.currency = currency;
        this.rateToUah = rateToUah;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public double getRateToUah() { return rateToUah; }
    public void setRateToUah(double rateToUah) { this.rateToUah = rateToUah; }
}

