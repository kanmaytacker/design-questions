
# Design a Restaurant Management System

- [Design a Restaurant Management System](#design-a-restaurant-management-system)
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
  - [API design](#api-design)
  
Restaurants (including bars, food trucks, and other foodservice businesses) have unique needs that a conventional POS system may not meet. For example, a typical feature is an ingredient-level inventory that lets you track items that make up your menu down to the last clove of garlic. This solves one of the main pain points in running a restaurant: how to do inventory. That’s something you won’t find in a retail POS, which usually count inventory stocks by-product and not what comprises it. A restaurant management system may also run on your tablet, so waiting staff can take orders and alert the kitchen and counter even before leaving the table.



![Restaurant Management System](https://rejag.com/wp-content/uploads/2017/11/restrant-and-bar-01-1.png)

> A Restaurant Management System is a software built to handle all restaurant activities in an easy and safe manner. This System will give the Restaurant management power and flexibility to manage the entire system from a single portal. The system allows the manager to keep track of available tables in the system as well as the reservation of tables and bill generation.


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
  
1. The restaurant will have different branches.
2. Each restaurant branch will have a menu.
3. The menu will have different menu sections, containing different menu items.
4. The waiter should be able to create an order for a table and add meals for each seat.
5. Each meal can have multiple meal items. Each meal item corresponds to a menu item.
6. The system should be able to retrieve information about tables currently available to seat walk-in customers.
7. The system should support the reservation of tables.
8. The receptionist should be able to search for available tables by date/time and reserve a table.
9. The system should allow customers to cancel their reservation.
10. The system should be able to send notifications whenever the reservation time is approaching.
11. The customers should be able to pay their bills through credit card, check or cash.
12. Each restaurant branch can have multiple seating arrangements of tables.
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

## API design

What will be some APIs that you would design for this system?

Look at the use cases and try to design APIs for each of them.

You can simply write the APIs in the following format:
`API name` - `HTTP method` - `URL` - `?Request body` - `?Response body`

You could also use a tool like [Swagger](https://swagger.io/) to design the APIs or follow [this](https://github.com/jamescooke/restapidocs) repository for a simple way to use Markdown to structure your API documentation.

```
```
