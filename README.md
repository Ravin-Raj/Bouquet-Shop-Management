# 🌸 Bouquet Shop Management (Java Swing)

**Bouquet Shop Management System** is a desktop-based Java application developed using **Java Swing** for the user interface and **Microsoft Access** as the backend database. It automates bouquet shop operations such as **user registration, login, bouquet selection, billing, and payment processing** using multiple payment modes.

---

## 🧩 Overview
The system simplifies sales management for bouquet shops by providing an interactive GUI. Users can browse bouquets, add them to their cart, and complete secure payments. It enhances both customer experience and administrative efficiency.

---

## 🎯 Objectives
- Automate bouquet sales and billing.  
- Provide secure and efficient login and registration.  
- Enable quick order management and dynamic pricing.  
- Reduce manual data entry errors.  
- Create a user-friendly offline application.

---

## ⚙️ Key Features
- User registration and login system.  
- Add-to-cart functionality with billing.  
- Multiple payment options (UPI, Card, QR, Net Banking).  
- Database integration via JDBC (UCanAccess).  
- Attractive Java Swing GUI.  
- Works offline with local database.

---

## 🛠️ Tech Stack

| Component | Technology |
|------------|-------------|
| **Frontend** | Java Swing |
| **Backend** | Microsoft Access |
| **Database Connectivity** | JDBC (UCanAccess) |
| **Language** | Java (JDK 8+) |
| **IDE** | Eclipse / IntelliJ / NetBeans |
| **OS** | Windows 10 / 11 |

---

## 🧱 Modules

### 1. Login Module
Authenticates users with credentials stored in the database.

### 2. Signup Module
Allows new users to register securely using name, email, mobile number, and password.

### 3. Home / Product Module
Displays available bouquets (Tulip, Rose, Lily, Mixed) and allows adding to cart.

### 4. Cart & Checkout Module
Shows selected bouquets, total cost, and allows modifying cart items.

### 5. Payment Module
Handles multiple payment modes such as UPI, QR Code, Net Banking, and Cards.

---

## 🧠 Database Design

### USER Table
| Field | Type | Description |
|--------|------|-------------|
| first | Text | First Name |
| last | Text | Last Name |
| mobile | Number | Mobile Number |
| email | Text | Email Address |
| password | Text | Password |
| cpassword | Text | Confirm Password |
| address | Text | Address |

### PRODUCT Table
| Field | Type | Description |
|--------|------|-------------|
| proname | Text | Bouquet Name |
| proprice | Number | Price |

---

## 💻 System Requirements

**Software:**
- Java JDK 8 or later  
- Microsoft Access  
- UCanAccess Driver  
- Windows 10 / 11  

**Hardware:**
- Intel i3 Processor or above  
- 4 GB RAM or higher  
- 1 GB Storage  

---

## ⚙️ Installation & Execution

### Step 1: Configure Database
Place `bouquetshop.accdb` inside a `database/` folder.

### Step 2: Add UCanAccess Libraries
Download and add the following `.jar` files to `lib/`:
- ucanaccess.jar
- jackcess.jar
- commons-lang.jar
- commons-logging.jar
- hsqldb.jar

### Step 3: Compile and Run
```bash
javac -cp "lib/*" -d build src/*.java
java -cp "build:lib/*" login
```

---

## 🧩 Code Example

### Database Connection
```java
Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
Connection conn = DriverManager.getConnection("jdbc:ucanaccess://D://Javaproject//Bouquetshop//bouquetshop.accdb");
```

### Login Validation
```java
String sql = "SELECT * FROM user WHERE mobile='" + mobile + "' AND password='" + pass + "'";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql);
if(rs.next()) {
    JOptionPane.showMessageDialog(null, "Login Successful!");
} else {
    JOptionPane.showMessageDialog(null, "Invalid Credentials!");
}
```

### Insert Product Data
```java
PreparedStatement ps = conn.prepareStatement("INSERT INTO product (proname, proprice) VALUES (?, ?)");
ps.setString(1, "Rose Bouquet");
ps.setDouble(2, 750.00);
ps.executeUpdate();
```

---

## 🖼️ UI Flow
1. **Login Page** – User Authentication  
2. **Signup Page** – New User Registration  
3. **Home Page** – Browse Bouquets  
4. **Cart Page** – Order Summary  
5. **Payment Page** – Complete Transaction  

---

## 🌟 Advantages
- Reduces manual errors.  
- Improves transaction efficiency.  
- Provides secure login and payment features.  
- User-friendly desktop interface.  
- Works offline without internet.

---

## 🔮 Future Enhancements
- Integrate online payment gateways.  
- Add customer order history.  
- Enable SMS/email notifications.  
- Deploy cloud-based version.  
- Create a mobile version using JavaFX or Kotlin.

---

## 🧾 Conclusion
The **Bouquet Shop Management System** automates bouquet sales and simplifies operations. It’s an ideal solution for small flower businesses looking to transition from manual to digital management.

---

## 👨‍💻 Developers
- **Ravin Raj S (23322009)**  
- **Harish R (23322030)**  

**Department of Computer Science and Applications**  
**The Gandhigram Rural Institute (Deemed to be University)**  
**May 2024**

---

## 📚 References
- [Java Swing Documentation](https://docs.oracle.com/javase/tutorial/uiswing/)  
- [UCanAccess Driver Guide](http://ucanaccess.sourceforge.net/site.html)  
- [Stack Overflow - JDBC Examples](https://stackoverflow.com/questions/tagged/jdbc)

---

## 🪪 License
This project is created for **academic purposes** and distributed under the **MIT License**.
