# 🏦 Bank System (JPA + Hibernate + PostgreSQL)

Учебный проект на Java с использованием JPA, Hibernate и PostgreSQL.  
Реализованы операции пополнения, перевода, конвертации валют и расчёта общей суммы пользователя.

## 📂 Структура проекта
- Users — пользователи системы  
- Accounts — счета (USD, EUR, UAH)  
- Transactions — операции (пополнение, перевод, конвертация)  
- Exchange Rates — курсы валют  
- Clients / Orders / Products — бизнес‑логика заказов

## ⚙️ Технологии
Java 17 • Hibernate 6 • PostgreSQL 13 • JPA

## ▶️ Пример использования
```java
transactionDAO.deposit(account1, 150.0);
transactionDAO.transfer(account1, account2, 50.0);
transactionDAO.convert(account1, account2, 20.0, 40.0);
System.out.println("💰 Общая сумма пользователя в UAH: " + transactionDAO.getTotalInUAH(user1.getId()));
## 🚀 Как запустить проект
1. Создайте базу данных `bank` в PostgreSQL.
2. Укажите параметры подключения в `persistence.xml`.
3. Выполните SQL для курсов валют:
   ```sql
   INSERT INTO exchange_rates (currency, rateToUah)
   VALUES ('USD', 40.0), ('EUR', 43.0), ('UAH', 1.0);

