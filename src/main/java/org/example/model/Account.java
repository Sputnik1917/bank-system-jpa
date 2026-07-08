package org.example.model;



import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String currency;
    private double balance;

    public Account() {}

    public Account(User user, String currency, double balance) {
        this.user = user;
        this.currency = currency;
        this.balance = balance;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
