package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Client;
import org.example.model.Product;
import org.example.model.Order;

import java.util.List;

public class OrderDAO {
    private final EntityManager em;

    public OrderDAO(EntityManager em) {
        this.em = em;
    }

    public void createOrder(Client client, Product product, int quantity) {
        em.getTransaction().begin();
        Order order = new Order(client, product, quantity);
        em.persist(order);
        em.getTransaction().commit();
    }
    public List<Order> getOrdersByClient(Client client) {
        return em.createQuery("SELECT o FROM Order o WHERE o.client = :client", Order.class)
                .setParameter("client", client)
                .getResultList();
    }
}
