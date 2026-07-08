package org.example.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;
    private Timestamp orderDate;

    public Order() {}
    public Order(Client client, Product product, int quantity) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = new Timestamp(System.currentTimeMillis());
    }

    public int getId() { return id; }
    public Client getClient() { return client; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public Timestamp getOrderDate() { return orderDate; }
}





















