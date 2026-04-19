# Stock Item Catalog System

### Student Name

#### Gulzhana Abdykhalykova

## Description:

#### This project is a stock item catalog system developed in Java.

#### The program allows the user to manage products using a command-line interface (CLI).

#### The main idea of the program is to store information about products such as:

#### * name

#### * quantity

#### * price

#### * category

#### The user can interact with the system through a menu and perform different operations.

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
#### Then it shows a menu where the user can choose an action.

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
#### Each product is saved in one line using this format:

#### Apple,10,50,Fruit
#### Milk,5,80,Dairy

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

#### Also, the program checks if the name field is empty.

## Challenges

#### While working on this project, I had some difficulties with:

#### * reading and writing files
#### * handling user input
#### * understanding OOP concepts

#### But after practice, I was able to solve these problems.

## Conclusion

#### This project helped me better understand Java programming, especially OOP principles and file handling.
#### It also improved my ability to design and organize code into different classes.