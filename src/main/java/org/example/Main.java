
package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.example.dao.AccountDAO;
import org.example.dao.OrderDAO;
import org.example.dao.TransactionDAO;
import org.example.dao.UserDAO;

import org.example.model.Client;
import org.example.model.Product;
import org.example.model.Order;
import org.example.model.User;
import org.example.model.Account;
import org.example.model.Transaction;


import java.util.List;


public class  Main {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bankPU");
        EntityManager em = emf.createEntityManager();

        UserDAO userDAO = new UserDAO(em);
        AccountDAO accountDAO = new AccountDAO(em);
        TransactionDAO transactionDAO = new TransactionDAO(em);
        OrderDAO orderDAO = new OrderDAO(em);

        // --- Пользователь и счета ---
        User user1 = new User("Саша", "sasha@example.com");
        userDAO.addUser(user1);

        Account account1 = new Account(user1, "USD", 500.0);
        Account account2 = new Account(user1, "UAH", 200.0);
        Account account3 = new Account(user1, "EUR", 100.0);
        em.getTransaction().begin();
        em.persist(account1);
        em.persist(account2);
        em.persist(account3);
        em.getTransaction().commit();

        transactionDAO.transfer(account1, account2, 100.0);

        // --- Клиент, продукт и заказ ---


        transactionDAO.transfer(account1, account2, 100.0);


        transactionDAO.deposit(account1, 150.0);
        transactionDAO.transfer(account1, account2, 50.0);
        transactionDAO.convert(account1, account2, 20.0, 40.0);

        double totalUAH = transactionDAO.getTotalInUAH(user1.getId());
        System.out.println("💰 Общая сумма пользователя в UAH: " + totalUAH);

// --- Клиент, продукт и заказ ---
        Client client1 = new Client("Иван", "ivan3@example.com");


        Product product1 = new Product("Ноутбук", 25000.0, 10);



        em.getTransaction().begin();
        em.persist(client1);
        em.persist(product1);
        em.getTransaction().commit();

        orderDAO.createOrder(client1, product1, 2);

        List<Order> orders = orderDAO.getOrdersByClient(client1);
        for (Order o : orders) {
            System.out.println(o);
        }




        em.close();
        emf.close();
    }
}












