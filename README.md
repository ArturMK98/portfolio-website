# Personal Portfolio Website

A personal portfolio website built with Spring Boot and Thymeleaf to showcase projects and skills.

The site is designed to be simple, responsive, and easy to extend as new projects are added.

---

## Tech Stack

- Java 21
- Spring Boot 4.0.2
- Thymeleaf
- Bootstrap 5
- HTML / CSS
- JSON-based data storage
- Formspree (contact form handling)

---

## Features

- Multi-page responsive layout
- JSON-driven project and profile data
- Reusable Thymeleaf templates and layouts
- Project listing with dynamic technology tags
- Individual project detail pages
- Integrated contact form using Formspree
- Clean MVC architecture

---

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── io.github.arturkarolewski.portfolio/
│   │       ├── HomeController.java
│   │       ├── PortfolioApplication.java
│   │       ├── model/
│   │       │   ├── About.java
│   │       │   ├── Cv.java
│   │       │   ├── Profile.java
│   │       │   └── Project.java
│   │       └── service/
│   │           ├── AboutService.java
│   │           ├── CvService.java
│   │           ├── ProfileService.java
│   │           └── ProjectService.java
│   └── resources/
│       ├── templates/
│       │   ├── layout.html
│       │   ├── index.html
│       │   ├── projects.html
│       │   ├── project-detail.html
│       │   ├── contact.html
│       │   ├── cv.html
│       │   └── about.html
│       ├── static/
│       │   ├── css/
│       │   │   └── styles.css
│       │   └── img/
│       └── data/
│           ├── profile.json
│           └── projects.json
```

---

## Running the Project Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/ArturMK98/portfolio-website.git
   ```

2. Navigate into the project directory:
   ```bash
   cd portfolio-website
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Open your browser at:
   ```
   http://localhost:8080
   ```

---

## Contact Form

The contact form is integrated using **Formspree** to handle submissions without requiring backend email configuration.

To use your own Formspree account, replace the form endpoint in `contact.html`:

```html
<form action="https://formspree.io/f/YOUR_FORM_ID" method="post">
```

---

## Screenshots

Screenshots will be added as the project evolves.
