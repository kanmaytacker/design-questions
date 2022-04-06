Machine Coding
--------------

Requirements Gathering, Clarifying Questions
============================================
1. Basic problem and fundamental requirements
2. Generalize the design & ask questions about that
3. Future Scope

-- --

E-R Diagram
===========
1. Entities
   - attributes
   - behavior
2. Relationships
    - cardinality
    - generalization (is-a)
    - association (has-a)
        + aggregation (no-ownership)
        + composition (ownership)

-- --

Coding
======

1. Clean Architecture - way/guideline for structuring and building your code
2. Your directory structure / code structure should tell you exactly what you're building
3. A good architecture allows you to delay the important decisions to as late as possible

Central thing of our problem statement
- Entities, Relations b/w the entities & business logic

- Are we knowledgeable enough to decide exactly what DB we should use?
- Are we knowledgeable enough to decide exactly framework we should use?
   + web
       - http
       - websockets
   + commandline
   + desktop application
   + android app
   

1. Code the entities & relations & business logic (Domain)
2. Usecases
   - user logging in / logging out / updating profile
   - ticket booking / cancel
3. How to interact with the outside world?
   - webserver
   - command line interface
4. Frameworks / libraries

-- --

User should be minimal
======================

- users can be of multiple types
- customer / employees / partnerships
- we don't want to put private/profile information in the user object
- have ONLY the authentication & autorization info in the User
- authentication: checking if the user is the person who they claim to be
    + username  (maybe your phone/email/string)
    + password
- authorization: does the user have the required permissions/authority
    + Role Based Authorization Control (RBAC)
        - roles: instructor, mentor, admin
        - privileges: add a new lecture / shift a lecture / message any mentee / view someones resume

-- --

Enum vs Entity
--------------
- enums are good for static analysis and for code
- drawback: add / remove an option, you have to make a code change!

-- --

Best Practices around password storage
======================================
- https://github.com/plaintextoffenders/plaintextoffenders/blob/master/offenders.csv
- password must be b/w 8 .. 20 chars: varchar(20) 
- hashing & salting your password
- Ashish - "Prashant"
- Hash(Prashant)  => shfsduhf => database
- Hash(Prashant) => shfsduhf => does this match the value in my db?

- if Ashish and Aakash had the same password -> qwerty, password1, abcdefgh, zaqwsx
- hash(qwerty) => kjdbfsf
- hash(qwerty) => kjdbfsf
- dictionary of commonly used password -> hash => rainbow table attack

- Ashish => ;sdf;sduf
- Aakash => poqjojesf
- hash(password+salt)
- hash(qwerty;sdf;sduf) => wbf;ewbf;owe, ;sdf;sduf
- hash(qwerypoqjojesf) => sdbf;sdkbf;n, poqjojesf
-- --

Encoding:
- Representing information in some or another manner
- Image -> jpeg, png, gif, svg, bmp, raw
         --------lossy-----------  --lossless--
- Audio -> mp3, wav, au3, wmv, aac, mp4
- Text -> base64, ASCII, utf-8, unicode
- Numbers -> hex, binary

Encryption:
- Making the information garbage for everyone except the authorized/intended reader
- If you don't have the "key" -> you can't make sense of the info
- If you do have the "key" -> you can easily reverse the encryption and get the plaintext back

Symmetric Key Cryptography: same key for locking an unlocking
- Ceaser / AES / DES
Assymteric/Public Key Cryptogrpahy: 1 key to lock and a different key to unlock
- RSA

Hashing:
- Compressing the information in a lossy manner
- Making the information random
- a single bit change to the file contents will completely change the hash
- it IMPOSSIBLE to go back from the has to the plaintext
- MD5, BCrypt, SHA
- do NOT use MD5
-- --

UUID
Long -> Auto-generated  monotonic

Scaler.com
Google.com / IBM / Oracle
you architect some software today

Integer -> 32bit integers (4 bytes)
-2^31 .. 2^31 - 1 (signed)
0 .. 2^32 - 1     (unsigned)
2^32 ~ 4 billion
Number of people in the world? 7-8 billion
Number of devices? Trillions

String -> not a good idea. Take up a lot of space, comparisons are slow
rtl/ltr, ascii/unicode

Auto
Base64 string - X
ObjectId - X


-- --

```java
// Uber

enum Color {
    GREEN,
    ..
}

class Car {
    String licensePlate;
    String model;
    String color; // arbitrary?
    // turquoise blue
    // brick red
    // mauve
    // hooloovoo
}

public enum Role {
    ADMIN,
    CUSTOMER,
    PaidCustomer, // run the test, make the pull request // reviewed // merged // qa // staging server // AB-tested on 5% of production // public
    PARTNERSHIP
}
```