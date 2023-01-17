# Implementing a Parking Lot Management System

We have successfully designed a parking lot management system. Now, it's time to implement it.
A thorough design removes a lot of confusion and makes implementation easier.
However, implementation is not a piece of cake. It requires a lot of effort and may require you to make small adjustments to your design.

This is why it helps to list down the steps that you need to follow to implement the design.

## Steps to implement a Parking Lot Management System

1. `Models` - The easiest part of the implementation. You just need to create the models and their relationships from the class diagram.

!!! note You can find the class diagram [here](../../../../../../../notes/04-design-a-parking-lot-answers.md#class-diagram).

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/tree/parking-lot-issue-ticket/src/main/java/com/scaler/lld/inclass/parking/models">Models</a>
</details>

---
1. `Create a Parking Lot` - This is the first step in the implementation and will be used by the admins to create a parking lot. Structure the code using the 3 layer architecture. Some points to think about:
   - What will the request look like?
   - How will you translate the request into the storage model?
   - What else do you have to store along with the parking lot?

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/parking-lot-issue-ticket/src/main/java/com/scaler/lld/inclass/parking/controllers/ParkingLotController.java">ParkingLotController</a>
</details>

---
2. `Issue a Ticket` - This is the second step in the implementation and will be used by the customers to issue a ticket. Some points to think about:
   - What will the request look like?
   - What validations do you need to perform before issuing a ticket?
   - What other entities do you need to create along with the ticket?
   - How do you assign a parking spot to the ticket?

<details>
<summary>Solution</summary>
<a href="https://github.com/kanmaytacker/design-questions/blob/parking-lot-issue-ticket/src/main/java/com/scaler/lld/inclass/parking/controllers/TicketController.java">TicketController</a>
</details>

---
3. `Refactor issuing a ticket flow` - Can we refactor the spot assignment flow to make it more extensible? Will we be able to add more spot assignment algorithms easily in the future? Think of using a design pattern that allows us to add new algorithms in a reusable way.

---
### Assignment
4. `Exit a Parking Lot` - This is the third step in the implementation and will be used by the customers to exit a parking lot. Some points to think about:
   - What will the request look like?
   - What validations do you need to perform before exiting a parking lot?
   - What other entities do you need to update along with the ticket?
   - How do you calculate the parking fee in an extensible way?