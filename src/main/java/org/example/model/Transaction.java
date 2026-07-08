package org.example.model;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_from")
    private Account accountFrom;

    @ManyToOne
    @JoinColumn(name = "account_to")
    private Account accountTo;

    private double amount;
    private String type;
    private LocalDateTime date = LocalDateTime.now();

    public Transaction() {}

    public Transaction(Account accountFrom, Account accountTo, double amount, String type) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.type = type;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public Account getAccountFrom() { return accountFrom; }
    public void setAccountFrom(Account accountFrom) { this.accountFrom = accountFrom; }
    public Account getAccountTo() { return accountTo; }
    public void setAccountTo(Account accountTo) { this.accountTo = accountTo; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}






















