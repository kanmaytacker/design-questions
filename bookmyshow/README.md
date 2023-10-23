# Implementing BookYourShow

We have successfully designed BookYourShow. The implementation will be focussed on the following topics:
1. Creating REST APIs using Spring Boot
2. Integrating a database using Spring Data JPA
3. Concurrency and locking

## Steps to implement a Parking Lot Management System

1. `User API` - We are going to be using Spring Boot to create our APIs. Let us start with creating an API for registering users. Some points to think about:
    - What will the request look like?
    - What validations do you need to perform before creating a user?
    - What will the response look like?

Start by creating the respective controllers and services.

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/master/src/main/java/com/scaler/lld/bookmyshow/services/UserService.java">UserService</a>
</details>

---

2. `Ticket API` - This is the second step in the implementation and will be used by the customers to book a ticket. Some points to think about:
    - What will the request look like?
    - What validations do you need to perform before issuing a ticket?
    - What other entities do you need to create along with the ticket?
    - How do you assign a parking spot to the ticket?

Steps to implement:
1. Validate if the show can still be booked
2. Validate if the seats are available
3. Mark the seats as locked
4. Create a ticket and persist it

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/bms-v3/src/main/java/com/scaler/lld/bookmyshow/services/BookingService.java">TicketService</a>
</details>

---
## Additional steps

3. `Encoding user password` - We are currently storing the user password as plain text. This is a security risk. We need to encode the password before storing it in the database. We will be using `BCryptPasswordEncoder` to encode the password.
4. `Concurrency and locking` - What would happen if two users try to book the same seat at the same time? We need to make sure that the seats are not double booked. This is where transactions and locking come into play. We will be using `@Transactional` annotation to make sure that the transaction is atomic. We will also be using `@Lock` annotation to make sure that the seats are locked before they are booked.

---
## Creating a database

1. Connect to MySQL -
```
> mysql

```
2. Create a databse
```
kingk=# create database bms;
Query OK, 1 row affected (0.02 sec)
```

3. Create a role
```
kingk=# create user api_user;
Query OK, 0 rows affected (0.01 sec)
```

4. Grant privileges
   Type "help" for help.
```
kingk=# GRANT ALL PRIVILEGES ON bms TO api_user;
Query OK, 0 rows affected (0.02 sec)
```