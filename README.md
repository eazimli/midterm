# Library App
 ### Registration
 ```sh
 POST| http://localhost:8080/auth/register
 ```
body
 ```sh
{  "fisrtName": "fisrtName",
   "lastName": "lastName",
    "email": "example@ada.edu.az",
    "password": "qwerty123"
}
 ```
 ### Login
  ```sh
  POST| http://localhost:8080/auth/login
  ```
body
 ```sh
{  "email": "example@ada.edu.az",
       "password": "qwerty123"
}
 ```
### pick-up book
  ```sh
  POST| http://localhost:8080/user/pick
  ```
body
 ```sh
{  
    "bookId": "1"
}
 ```
### drop-off book
  ```sh
  POST| http://localhost:8080/user/drop
  ```
body
 ```sh
{  
    "bookId": "1"
}
 ```
### list of user book
  ```sh
  POST| http://localhost:8080/user/all
  ```
### books
  ```sh
  GET| http://localhost:8080/books
  ```
 byId
  ```sh
  GET| http://localhost:8080/book/id
  ```
#### byNameOrAuthorOrCategory
  ```sh
  GET| http://localhost:8080/book/get
  ```
body
 ```sh
{  
  "name": "Hamlet"
}
 ```
### categories
  ```sh
  GET| http://localhost:8080/categories
  ```
 byId
  ```sh
  GET| http://localhost:8080/categories/id
  ```
### Comment to book

  ```sh
  POST| http://localhost:8080/comment
  ```
body
 ```sh
{
"bookId": 4,
"author": "Joe",
"comment": "very good book for everyone"
}
 ```
### Reply to comment

  ```sh
  POST| http://localhost:8080/reply
  ```
body
 ```sh
{"commentId":"60786f4f7995c7132a3922e0",
  "author":"Elovset",
  "reply":"I am not agree"
}
 ```