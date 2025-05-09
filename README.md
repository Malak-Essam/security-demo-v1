# Spring Security Demo Application  
**A simple Spring Boot application demonstrating authentication, authorization, and role-based access control (RBAC).**

---

## 📋 Features  
- **Role-Based Access Control (RBAC)**:  
  - Public endpoints accessible to all.  
  - User endpoints restricted to `USER` role.  
  - Admin endpoints restricted to `ADMIN` role.  
- **In-Memory User Management**: Preconfigured users (`user` and `admin`).  
- **Secure Password Encoding**: Uses `bcrypt` for password hashing.  
- **Default Login/Logout**: Spring Security’s auto-generated login page.  

---

## 🛠️ Prerequisites  
- Java 17+  
- Maven  
- IDE (IntelliJ, Eclipse, etc.)  

---

## 🚀 Getting Started  
1. **Clone the Repository**:  
   ```bash
   git clone [your-repo-url]  
   cd spring-security-demo

2. Build the Project:
   ```mvn clean install```
3. Run the Application:
4. mvn spring-boot:run

## 🔑 Default Users
```
Username  Password      Role
user      password123	USER
admin     admin       ADMIN
```
## 🌐 API Endpoints
```
Endpoint	      Method	Access        	Example Response
/api/v1/public/hello   GET     Public	        "Hello, Public!"
/api/v1/user/hello     GET     Requires USER    "Hello, User!"
/api/v1/admin/hello    GET     Requires ADMIN   "Hello, Admin!"
```
