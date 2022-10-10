# Design a pen

## Requirements

* A pen is anything that can write.
* Pen can be Gel, Ball, Fountain, Marker.
* Ball Pen and Gel Pen have a Ball Pen Refill and a Gel Pen Refill respectively to write.
* A refil has a tip and an ink.
* Ink can be of different colour
* A fountain pen has an Ink.
* Refil has a radius. 
* For fountain pen, its tip has a radius.
* Each pen can write in a different way.
* Some pens write in the same way.
* Every pen has a brand and a name.
* Some pens may allow refilling while others might not.

## Entities and Attributes

* Pen
  * Brand
  * Name
  * Type (Gel, Ball, Fountain, Marker)
  * Price
*  Refill
  * Type (Ball, Gel)
  * Ink
  * Nib
* Ink
  * Colour
  * Brand
  * Type (Gel, Ball, Fountain)
* Nib
  * Radius
  * Type (Fountain, Ball, Gel)  

### Different types of pens
* Gel Pen
  * Type - `Gel`
  * Refill
    * Type - `Gel`
    * Nib - `Gel`
    * Ink
      * Type - `Gel`
    * Refillable - `Yes`

* Ball Pen
  * Type - `Ball`
  * Refill
    * Type - `Ball`
    * Nib - `Ball`
    * Ink
      * Type - `Ball`
    * Refillable - `Yes`

* Throwaway Pen
  * Type - `Throwaway`
  * Refill
    * Type - `Ball`
    * Nib - `Ball`
    * Ink
      * Type - `Ball`
    * Refillable - `No`

* Fountain Pen
  * Type - `Fountain`
  * Ink
    * Type - `Fountain`
  * NiB
    * Type - `Fountain`


## Single class

```mermaid
classDiagram
    class Pen {
        -String brand
        -String name
        -PenType type
        -double price
        -Refill refill
        -Ink ink
        -Nib nib
        +write() void
    }

    class PenType {
        <<enumeration>>
        GEL
        BALL
        FOUNTAIN
        MARKER
        THROW_AWAY
    }

    class Refill {
        -RefillType type
        -Ink ink
        -Nib nib
        -boolean refillable
    }

    class RefillType {
        <<enumeration>>
        GEL
        BALL
    }

    class Ink {
        -String colour
        -String brand
        -InkType type
    }

    class InkType {
        <<enumeration>>
        GEL
        BALL
        FOUNTAIN
    }

    class Nib {
        -double radius
        -NibType type
    }

    class NibType {
        <<enumeration>>
        GEL
        BALL
        FOUNTAIN
    }

    Pen "*" --o  "1" PenType : has a
    Pen "1" --* "1" Refill : has a
    Pen "1" --* "1" Ink : has a
    Pen "1" --* "1" Nib : has a

    Refill "*" --* "1" RefillType : has a
    Refill "1" --* "1" Ink : has a
    Refill "1" --* "1" Nib : has a

    Ink "*" --* "1" InkType : has a

    Nib "*" --* "1" NibType : has a

```

### Java Code

```java
public class Pen {
    private String brand;
    private String name;
    private PenType type;
    private double price;
    private Refill refill;
    private Ink ink;
    private Nib nib;

    public void write() {
        switch (type) {
            case GEL:
                System.out.println("Gel Pen writes");
                break;
            case BALL:
                System.out.println("Ball Pen writes");
                break;
            case FOUNTAIN:
                System.out.println("Fountain Pen writes");
                break;
            case MARKER:
                System.out.println("Marker Pen writes");
                break;
            case THROW_AWAY:
                System.out.println("Throwaway Pen writes");
                break;
        }

        throw new IllegalArgumentException("Invalid Pen Type");
    }

    public void changeRefill(Refill refill) {
        if (this.refill.isRefillable()) {
            this.refill = refill;
        }
    }

    public void changeInk(Ink ink) {
        this.ink = ink;
    }
}
```

### Problems
  * `Single Responsibility Principle` is violated. There are multiple reasons to change the class such as modifying a single type of pen.
  * `Open Closed Principle` is violated. Adding a new type of pen requires changing the class.
  * `Null checks` are required for handling refill and ink for fountain pens.
  * `Object creation` is complex

## Multiple classes (Inheritance)

```mermaid
classDiagram
    class Pen {
        <<abstract>>
        -String brand
        -String name
        -PenType type
        -double price
        +write()* void
    }

    class GelPen {
        -Refill refill
        +write() void
    }

    class BallPen {
        -Refill refill
        +write() void
    }

    class FountainPen {
        -Ink ink
        +write() void
    }

    class ThrowawayPen {
        -Refill refill
        +write() void
    }

    class PenType {
        <<enumeration>>
        GEL
        BALL
        FOUNTAIN
        MARKER
        THROW_AWAY
    }

    class Refill {
        -RefillType type
        -Ink ink
        -Nib nib
        -boolean refillable
    }

    class RefillType {
        <<enumeration>>
        GEL
        BALL
    }

    class Ink {
        -String colour
        -String brand
        -InkType type
    }

    class InkType {
        <<enumeration>>
        GEL
        BALL
        FOUNTAIN
    }

    class Nib {
        -double radius
        -NibType type
    }

    class NibType {
        <<enumeration>>
        GEL
        BALL
        FOUNTAIN
    }

    Pen "*" --o  "1" PenType : has a


    Pen <|-- GelPen
    Pen <|-- BallPen
    Pen <|-- FountainPen
    Pen <|-- ThrowawayPen

    GelPen "1" --* "1" Refill : has a
    BallPen "1" --* "1" Refill : has a
    ThrowawayPen "1" --* "1" Refill : has a

    FountainPen "1" --* "1" Ink : has a
    FountainPen "1" --* "1" Nib : has a

    Refill "*" --* "1" RefillType : has a
    Refill "1" --* "1" Ink : has a
    Refill "1" --* "1" Nib : has a

    Ink "*" --* "1" InkType : has a

    Nib "*" --* "1" NibType : has a

```

### Java Code

[Java Code](../src/main/java/com/scaler/lld/pen/multipleclasses/)

### Improvements
  * `Single Responsibility Principle` is followed. Each class has a single responsibility.
  * `Open Closed Principle` is followed. Adding a new type of pen does not require changing the class.
  * `Null checks` are not required for handling refill and ink for fountain pens.

### Problems
  * `Object creation` is still complex
  * `Liskov Substitution Principle` is violated since `FountainPen` does not have a refill, and it throws an exception when `changeRefill` is called.
  * `Code duplication` 
  * `Subclasses` are used to create objects.

---

## Reducing code duplication using Strategy Pattern

```mermaid
classDiagram
    class Pen {
        <<abstract>>
        -String brand
        -String name
        -PenType type
        -double price
        -WritingStrategy writingStrategy
        +write() void
        +changeRefill(Refill refill)* void
    }

    class WritingStrategy {
        <<interface>>
        +write() void
    }

    class SmoothWritingStrategy {
        +write() void
    }

    class RoughWritingStrategy {
        +write() void
    }
    
    WritingStrategy <|-- SmoothWritingStrategy
    WritingStrategy <|-- RoughWritingStrategy
    Pen "*" --o "1" WritingStrategy : has a
```

### Java Code
[Pen class with strategy](../src/main/java/com/scaler/lld/pen/withstrategy/Pen.java)

---

## Avoiding LSP using abstract classes

```mermaid
classDiagram
    class Pen {
    <<abstract>>
    -String brand
    -String name
    -PenType type
    -double price
    -WritingStrategy writingStrategy
    +write() void
}

class RefillablePen {
    <<abstract>>
    -Refill refill
    +changeRefill(Refill) void
    +getRefill() Refill
    +isRefillable() boolean
}

class NonRefillablePen {
    <<abstract>>
    -Ink ink
    -Nib nib
    +changeInk(Ink) void
}

class GelPen {
    +write() void
    +changeRefill(Refill) void
    +getRefill() Refill
    +isRefillable() boolean
}

class BallPen {
    +write() void
    +changeRefill(Refill) void
    +getRefill() Refill
    +isRefillable() boolean
}

class FountainPen {
    +write() void
}

Pen <|-- RefillablePen
Pen <|-- NonRefillablePen
RefillablePen <|-- GelPen
RefillablePen <|-- BallPen
NonRefillablePen <|-- FountainPen

```

### Java Code
[Pen class with abstract classes](../src/main/java/com/scaler/lld/pen/abstractclasses/)

### Improvements
  * `Liskov Substitution Principle` is followed since `FountainPen` does not have a refill, and it throws an exception when `changeRefill` is called.
  * No field duplication in child classes.

### Problems
  * Behaviour is tied to the class hierarchy. Adding a new type of pen requires changing the class hierarchy.

## Avoiding LSP violation using interface

```mermaid
classDiagram
    class Pen {
        <<abstract>>
        -String brand
        -String name
        -PenType type
        -double price
        -WritingStrategy writingStrategy
        +write() void
    }

    class RefillPen {
        <<interface>>
        +changeRefill(Refill) void
        +getRefill() Refill
        +isRefillable() boolean
    }

    class GelPen {
        -Refill refill
        +write() void
        +changeRefill(Refill) void
        +getRefill() Refill
        +isRefillable() boolean
    }

    class BallPen {
        -Refill refill
        +write() void
        +changeRefill(Refill) void
        +getRefill() Refill
        +isRefillable() boolean
    }

    class FountainPen {
        -Ink ink
        -Nib nib
        +write() void
    }

    Pen <|-- GelPen : extends
    Pen <|-- BallPen : extends
    Pen <|-- FountainPen : extends

    RefillPen <|-- GelPen : implements
    RefillPen <|-- BallPen : implements
```

### Java Code
[Pen class with interface](../src/main/java/com/scaler/lld/pen/withinterface/)

### Problems
  * Field duplication in child classes.