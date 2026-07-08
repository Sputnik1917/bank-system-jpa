package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Account;
import org.example.model.User;
import org.example.model.ExchangeRate;

public class TransactionDAO {
    private final EntityManager em;

    public TransactionDAO(EntityManager em) {
        this.em = em;
    }

    public void deposit(Account account, double amount) {
        em.getTransaction().begin();
        account.setBalance(account.getBalance() + amount);
        em.merge(account);
        em.getTransaction().commit();

        System.out.println("✅ Пополнение: +" + amount + " " + account.getCurrency() +
                " на счёт " + account.getId());
    }

    public void transfer(Account from, Account to, double amount) {
        if (from.getBalance() < amount) {
            System.out.println("❌ Недостаточно средств!");
            return;
        }
        em.getTransaction().begin();
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        em.merge(from);
        em.merge(to);
        em.getTransaction().commit();

        System.out.println("✅ Перевод: " + amount + " " + from.getCurrency() +
                " со счёта " + from.getId() + " на счёт " + to.getId());
    }

    public void convert(Account from, Account to, double amount, double rate) {
        if (from.getBalance() < amount) {
            System.out.println("❌ Недостаточно средств!");
            return;
        }
        em.getTransaction().begin();
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount * rate);
        em.merge(from);
        em.merge(to);
        em.getTransaction().commit();

        System.out.println("✅ Конвертация: " + amount + " " + from.getCurrency() +
                " → " + (amount * rate) + " " + to.getCurrency());
    }

    // 👇 новый метод для подсчёта общей суммы в UAH
    public double getTotalInUAH(Long userId) {
        Double total = em.createQuery(
                        "SELECT SUM(a.balance * e.rateToUah) " +
                                "FROM Account a JOIN ExchangeRate e ON a.currency = e.currency " +
                                "WHERE a.user.id = :userId", Double.class)
                .setParameter("userId", userId)
                .getSingleResult();

        return total != null ? total : 0.0;
    }
}
