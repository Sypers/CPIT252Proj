# CPIT252Proj
A Project containing all the work for the cpit252 project
This is a car rental system that is used by two users: admin, and customer
The Customer can make new car reservations, cancel reservations, handover car, calculate reservation cost
The Admin can control car availability to the customer, and complete car handover operation by the customer
The Project Uses Singleton , Prototype , Command , Facade Design Patterns
Singleton in DBConnection.java
Prototype in Reservation.java and ReservationPrototype.java
Command in CrsClasses.Commands package
Facade in CustomerFacade.java
Instructions:
1- You need to import a mysql database using the sql file provided with the project
2- Make Sure the CRSClassesVer2 Project is imported into the CarRentalSystem Project and the Database driver is imported in the project library
3- Run the Server From ServerPKG in CarRentalSystem Project
4- Run the CarRentalSystem project or run an instance of LoginForm.
5- Use the admin or customer info registered in the database or create your own in mysql database.
User Info
Admin: mohammeda@crs.com | Pass: moh1234
Customer: khaled@gmail.com | Pass: abc123
