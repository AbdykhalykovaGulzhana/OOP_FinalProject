# Stock Item Catalog System

### Student Name

#### Gulzhana Abdykhalykova
#### Presentation link: https://canva.link/n7wcoqkzle39kcy

## Description:

#### This project is a stock item catalog system developed in Java.

#### The program allows the user to manage products using a command-line interface (CLI).

#### The main idea of the program is to store information about products such as:

#### * name

#### * quantity

#### * price

#### * category

#### The user can interact with the system through a menu and perform different operations.

## Objectives

#### The main goals of this project are:

#### * To implement CRUD operations (create, read, update, delete)
#### * To practice Object-Oriented Programming (OOP) concepts
#### * To work with file handling in Java
#### * To create a simple and user-friendly command-line interface
#### * To store and manage product data efficiently

## Project Requirement List

#### The system should:

#### 1. Allow users to add new products
#### 2. Display all products
#### 3. Update product information
#### 4. Delete products from the list
#### 5. Search products by name
#### 6. Save data to a file
#### 7. Load data from a file
#### 8. Validate user input (e.g., prevent empty fields and incorrect numbers)
#### 9. Handle errors using try-catch blocks
#### 10. Use Object-Oriented Programming principles
#### 11. Store data using ArrayList
#### 12. Provide a command-line interface for user interaction

## Main Features

#### The program supports the following operations:

#### * Add new product
#### * Show all products
#### * Update existing product
#### * Delete product
#### * Save data to file
#### * Load data from file

## How the Program Works

#### When the program starts, it loads data from a file called catalog.txt.

#### Example menu:

#### 1. Create product
#### 2. Show all products
#### 3. Update product
#### 4. Delete product
#### 5. Exit

#### The user enters a number, and the program performs the selected operation.

## Example of Usage

### Adding a product

#### Input:

#### Name: Apple
#### Quantity: 10
#### Price: 50
#### Category: Fruit

#### Output:
#### Product added

## Displaying products

#### Output:
#### Apple | 10 | 50 | Fruit

## Updating a product

#### Input:
#### Name: Apple
#### New quantity: 20
#### New price: 60

#### Output:
#### Product updated

## Deleting a product

#### Input:
#### Apple

#### Output:
#### Product deleted

## Data Storage

#### All data is stored in a file called catalog.txt.

#### Apple,10,50,Fruit
#### Milk,5,80,Dairy
#### Bread,15,40,Bakery
#### Rice,20,70,Grains
#### Eggs,30,10,Dairy

#### When the program starts, it reads this file and loads all products into memory.

## OOP Concepts Used

### Encapsulation

#### All fields in classes are private, and access is provided through getters and setters.

### Inheritance

#### The class Product extends the class Item.
#### This allows reuse of common fields like name, quantity, and price.

### Polymorphism

#### The method display() is overridden in the Product class.
#### This means the same method behaves differently depending on the class.

## Data Structure

#### The program uses ArrayList to store products.
#### This allows dynamic resizing and easy access to elements.

## Error Handling

#### The program uses try-catch blocks to handle incorrect input.
#### For example, if the user enters letters instead of numbers, the program shows an error message and does not crash.

## Conclusion

#### This project helped me better understand Java programming, especially OOP principles and file handling.