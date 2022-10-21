# Design a parking lot

> A parking lot or car park is a dedicated cleared area that is intended for parking vehicles. In most countries where cars are a major mode of transportation, parking lots are a feature of every city and suburban area. Shopping malls, sports stadiums, megachurches, and similar venues often feature parking lots over large areas
[Reference](https://github.com/tssovi/grokking-the-object-oriented-design-interview/blob/master/object-oriented-design-case-studies/design-a-parking-lot.md)

![Parking Lot](
    https://github.com/tssovi/grokking-the-object-oriented-design-interview/raw/master/media-files/parking-lot.png)

> Parking lot is an open area designated for parking cars. We will design a parking lot where a certain number of cars can be parked for a certain amount of time. The parking lot can have multiple floors where each floor carries multiple slots. Each slot can have a single vehicle parked in it.
[Reference](https://medium.com/double-pointer/system-design-interview-parking-lot-system-ff2c58167651)


![Parking Lot](https://miro.medium.com/max/640/1*-6QRtfh6OrHJBb7nJvsCVA.jpeg)

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

## Use case diagrams

Are the requirements clear enough to define use cases?
If not, try to think of the actors and their interactions with the system.

### Actors
What would be the actors in this system?
1. Customer
2. Parking Attendant, Operator
3. Admin

### Use cases

What would be the use cases i.e. the interactions between the actors and the system?

#### Actor 1

Name of the actor - `Admin`

Use cases: `CRUD`
1. `Create a parking lot`
2. `Create a parking floor`
3. `Add new parking spots`
4. `Update status of a parking spot`

#### Actor 2

Name of the actor - `Parking attendant`
Use cases:
1. `Check empty slots`
2. `Issue a ticket` - `Allocating a slot`
3. `Collect payment`
4. `Checkout` - `Has the user paid?`

#### Actor 3

Name of the actor - `Customer`
Use cases:
1. `Pay` - `Pay online`, `Pay at exit gate`
2. `Check status`

Add more actors and their use cases as needed.

```plantuml
@startuml
left to right direction
actor ParkingAttendant
actor Customer
actor Admin

rectangle FastAndCalm {
    Admin --> (Add a parking lot)
    Admin --> (Add a parking floor)
    Admin --> (Add a parking spot)
    Admin --> (Update status of parking spot)

    usecase "Pay" as Pay
    usecase "Pay Online" as PayOnline
    usecase "Pay Cash" as PayCash

    Customer --> (Pay)
    Customer --> (Check spot's status)

    PayOnline .> (Pay) : extends
    PayCash .> (Pay) : extends


    ParkingAttendant --> (Check empty slots)
    ParkingAttendant --> (Issue a ticket)
    ParkingAttendant --> (Collect payment)
    ParkingAttendant --> (Checkout)

    (Issue a ticket) .> (Allocate a slot) : includes
    Checkout .> (CheckPaymentStatus) : includes
}
@enduml
```

## Class diagram

What will be the major classes and their attributes?

```
    Class name
        - Attribute 1
        - Attribute 2
        ...
```

Draw the class diagram.
```
```

