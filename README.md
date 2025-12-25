# OIBSIP_JavaDevelopment_task1
OBJECTIVE:
The goal of this task was to build a simple Online Reservation System in Java that allows a user to log in, book tickets, view reservation details using a PNR number, and cancel tickets, while practicing core concepts like methods, menus, conditions, and user input handling.

STEPS: To achieve this, the steps followed were:
--Designing the basic flow of the system: first a login screen, then a main menu with options to make a reservation, cancel a ticket, view a reservation by PNR, or exit.
--Creating a reservation model to store details such as passenger name, train number, train name, source, destination, class type, date of journey, and an auto-generated PNR.
--Writing methods for each part of the system: a login method, a reservation method to collect user details and generate PNR, a method to display reservation details, and a cancellation method that confirms before deleting a booking.
--Adding a loop around the main menu so the user can perform multiple operations (book, view, cancel) in a single run, with simple checks for invalid input.

TOOLS:
--The tools and language features used were basic Java utilities and constructs:
--The Scanner class for reading user input from the console in a simple and interactive way.
--The Random class to generate a unique PNR number for each reservation.
--A Map (key–value store) to keep reservations in memory, with the PNR as the key so tickets can be quickly searched and cancelled.
--Control-flow structures like if-else, switch, and loops, along with small helper methods, to keep the code clear and easy to follow.

OUTCOME:
The result is a working console-based Online Reservation System where users can log in, book tickets with all required details, receive a generated PNR, view their reservation later using that PNR, and cancel tickets safely after seeing a summary on screen. The program stays simple, readable, and stable, making it a good practice project for understanding how real-world reservation systems work at a basic level.
