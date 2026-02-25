## E-Commerce Platform

A full-stack e-commerce application with Spring Boot backend and React frontend.

### Project Structure

```
E-Commerce/
├── backend/          # Spring Boot REST API
│   ├── src/
│   ├── pom.xml
│   └── mvnw.cmd
└── frontend/         # React + Vite
    ├── src/
    ├── package.json
    └── vite.config.js
```

### Quick Start

#### Backend

```bash
cd backend
./mvnw spring-boot:run
```

Server runs at `http://localhost:2424`

#### Frontend

```bash
cd frontend
npm install
npm run dev
```

App runs at `http://localhost:5173`

### Tech Stack

- **Backend**: Java 21, Spring Boot 3, Spring Security, JPA/Hibernate, PostgreSQL
- **Frontend**: React 18, Vite, React Router, Axios, React Toastify

### Features

- **JWT-based authentication**: user registration/login, role-based access for `ADMIN` and `USER`.
- **Product catalog**: products with categories, images, search by name/description.
- **Category management**: category CRUD (restricted to `ADMIN`).
- **Order & order items**: create orders, store products, quantity, and order status.
- **User & address**: user profile and shipping address management.
- **Admin operations**: management APIs for users, products, categories, and orders (restricted to `ADMIN`).
