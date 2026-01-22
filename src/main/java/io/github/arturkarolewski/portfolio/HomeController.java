package io.github.arturkarolewski.portfolio;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/projects")
    public String projects(Model model) {

        List<Project> projects = List.of(
                new Project(
                        "Portfolio Website",
                        "Spring Boot + Thymeleaf portfolio site with reusable layout and Bootstrap UI.",
                        List.of("Java", "Spring Boot", "Thymeleaf", "Bootstrap"),
                        "https://github.com/ArturMK98/portfolio-website"
                ),
                new Project(
                        "CanvasLite (POC)",
                        "Proof-of-concept web app focused on core flows and clean MVC structure.",
                        List.of("Spring MVC", "Bootstrap", "POC"),
                        ""
                )
        );

        model.addAttribute("projects", projects);
        return "projects";
    }

}
