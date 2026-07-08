package org.example.dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.Account;
import org.example.model.User;

public class AccountDAO {
    private final EntityManager em;

    public AccountDAO(EntityManager em) {
        this.em = em;
    }

    public void addAccount(User user, String currency, double balance) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Account account = new Account();
        account.setUser(user);
        account.setCurrency(currency);
        account.setBalance(balance);
        em.persist(account);
        tx.commit();
    }

    public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }
}
















