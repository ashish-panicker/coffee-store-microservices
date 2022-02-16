# Coffee Store Micoroservices

You have been assigned to create a microservice for a coffee store. The reqiuirments are
as follows. 

The store sells different types of coffee and snacks. Every day a set of menu is created in the store and the users will be able to order from the menu.

There are going to be four microservices in this application.

## Items Microservice

This service manages the food items that are available for order at the coffee store. The items are going to be stored in a database.

### API

The end points and theire functions are explained in the table below:

|Method|Endpoint|Function|
|:---:|:---:|:---:|
|GET|/items|Get all items from the databses in a page by page manner.|
|GET|/items/{id}|Get a specific item from the database.|
|POST|/items|Create a new item in the database.|
|PUT|/items/{id}|Update an item in the database.|
|DELETE|/items/{id}|Delete an item in the database.|

### Model for the API

```json
{
  "id": "",
  "name": "",
  "price": "",
  "description": "",
  "image": "",
  "updated_on": "",
}
```

## Menu Microservice

This service manages the menu for the coffee store. The menu is going to be stored in a database.

### API

The end points and their functions are explained in the table below:

|Method|Endpoint|Function|
|:---:|:---:|:---:|
|GET|/menu/{date}|Get a specific menu from the database for the provided date.|
|GET|/menu/{start_date}/{end_date}|Get a specific menus from the database for the provided date range.|
|GET|/menu/{month}|Get a specific menus from the database for the provided month.|
|POST|/menu|Create a new menu in the database.|
|PUT|/menu/{date}|Update a menu in the database.|
|DELETE|/menu/{date}|Delete a menu in the database.|

#### Data Integrity Consideration

- Only one menu can be created for a specific date.

### Model for the API

There is going to be **One-Many** relationship between the menu and the items.

```json
{
    "id": "",
    "menu_date":"",
    "items": [
        {}, {}, {}
    ],
    "updated_on": ""
}
```

## Orders Microservice

### API

### Model for the API

## Users Microservice

### API

### Model for the API
