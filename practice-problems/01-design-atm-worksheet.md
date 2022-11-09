# Design an ATM

- [Design an ATM](#design-an-atm)
  - [Context](#context)
    - [How ATM works?](#how-atm-works)
  - [Expectations](#expectations)
  - [Requirements gathering](#requirements-gathering)
  - [Requirements](#requirements)
  - [Use case diagrams](#use-case-diagrams)
    - [Actors](#actors)
    - [Use cases](#use-cases)
      - [Actor 1](#actor-1)
      - [Actor 2](#actor-2)
      - [Actor 3](#actor-3)
  - [Class diagram](#class-diagram)


## Context

> ATM is a machine that allows customers to perform financial transactions without the need for a human teller.

An automated teller machine (ATM) is an electronic telecommunications instrument that provides the clients of a financial institution with access to financial transactions in a public space without the need for a cashier or bank teller. ATMs are necessary as not all the bank branches are open every day of the week, and some customers may not be in a position to visit a bank each time they want to withdraw or deposit money.

![ATM](https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/ATM_750x1300.jpg/220px-ATM_750x1300.jpg)

### How ATM works?

The ATM will be managed by an operator, who operates the ATM and refills it with cash and receipts. The ATM will serve one customer at a time and should not shut down while serving. To begin a transaction in the ATM, the user should insert their ATM card, which will contain their account information. Then, the user should enter their Personal Identification Number (PIN) for authentication. The ATM will send the user’s information to the bank for authentication; without authentication, the user cannot perform any transaction/service.

The user’s ATM card will be kept in the ATM until the user ends a session. For example, the user can end a session at any time by pressing the cancel button, and the ATM Card will be ejected. The ATM will maintain an internal log of transactions that contains information about hardware failures; this log will be used by the ATM operator to resolve any issues.

1. Identify the system user through their PIN.
2. In the case of depositing checks, the amount of the check will not be added instantly to the user account; it is subject to manual verification and bank approval.
3. It is assumed that the bank manager will have access to the ATM’s system information stored in the bank database.
4. It is assumed that user deposits will not be added to their account immediately because it will be subject to verification by the bank.
5. It is assumed the ATM card is the main player when it comes to security; users will authenticate themselves with their debit card and security pin.


## Expectations
* Code should be functionally correct.
* Code should be modular and readable. Clean and professional level code.
* Code should be extensible and scalable. Means it should be able to accommodate new requirements with minimal changes.
* Code should have good OOP design principles.

## Requirements gathering

What are some questions you would ask to gather requirements?

```
```

## Requirements
What will be 10 requirements of the system, according to you?
Do not worry about the correctness of the requirements, just write down whatever comes to your mind.
Your job is not to generate the requirements, but get better at understanding problem statements and anticipating the functionalities your application might need.
```
```

<details>
  <summary><strong>Click to see the actual requirements</strong></summary>
  
The main components of the ATM that will affect interactions between the ATM and its users are:

  1. **Card reader:** to read the users’ ATM cards.
  2. **Keypad:** to enter information into the ATM e.g. PIN. cards.
  3. **Screen:** to display messages to the users.
  4. **Cash dispenser:** for dispensing cash.
  5. **Deposit slot:** For users to deposit cash or checks.
  6. **Printer:** for printing receipts.
  7. **Communication/Network Infrastructure:** it is assumed that the ATM has a communication infrastructure to communicate with the bank upon any transaction or activity.

  The user can have two types of accounts: 1) Checking, and 2) Savings, and should be able to perform the following five transactions on the ATM:

  1. **Balance inquiry:** To see the amount of funds in each account.
  2. **Deposit cash:** To deposit cash.
  3. **Deposit check:** To deposit checks.
  4. **Withdraw cash:** To withdraw money from their checking account.
  5. **Transfer funds:** To transfer funds to another account.
</details>

## Use case diagrams

Are the requirements clear enough to define use cases?
If not, try to think of the actors and their interactions with the system.

### Actors
What would be the actors in this system?
```
```

### Use cases

What would be the use cases i.e. the interactions between the actors and the system?

#### Actor 1

Name of the actor - ` `

Use cases:
```
1. 
2. 
3. 
4. 
```
#### Actor 2

Name of the actor - ` `
Use cases:
```
1. 
2. 
3. 
4. 
```

#### Actor 3

Name of the actor - ` `
Use cases:
```
1. 
2. 
3. 
4. 
```
Add more actors and their use cases as needed.

**Create a use case diagram for the system.**

```
```

## Class diagram

What will be the major classes and their attributes?

```
    Class name
        - Attribute 1
        - Attribute 2
        ...
```

List down the cardinalities of the relationships between the classes.
```
```

Draw the class diagram.
```
```