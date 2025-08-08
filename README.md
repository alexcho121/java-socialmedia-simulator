# MQGram – Java Social Media Simulator

MQGram is a lightweight social media simulation platform developed in core Java for the COMP1010 major assignment. It supports user registration, post creation, recursive comments, and persistent data storage using serialization.

## 🔧 Key Features
- Create user profiles and follow others
- Add posts and comment threads
- Nested (recursive) replies to comments
- Save/load data using file serialization
- Built with OOP: delegation, composition, recursion

## 📁 How to Run
javac src/*.java test/*.java
java -cp src Main

Make sure the data/ folder exists to avoid file errors.

📌 Authors & Responsibilities

  -Youngjun Cho – Post.java, App.java, integration & file I/O
  -Viviana Abusalah – Comment.java with recursion
  -Tung Lam Cao – User.java with serialization

🧪 Unit Tests
Includes full JUnit 5 test coverage:
  -UserTest.java
  -PostTest.java
  -CommentTest.java
  -AppTest.java

📷 UML Diagram
![UML Diagram](./VCC/mqgram_uml_diagram.png)
