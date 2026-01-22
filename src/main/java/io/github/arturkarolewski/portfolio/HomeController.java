package io.github.arturkarolewski.portfolio;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

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

    @GetMapping("/projects/{slug}")
    public String projectDetail(@org.springframework.web.bind.annotation.PathVariable String slug, Model model) {
    Project project = getProjects().stream()
        .filter(p -> p.slug().equals(slug))
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    model.addAttribute("project", project);
    return "project-detail";
}


    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", getProjects());
        return "projects";
    }

    private List<Project> getProjects() {
    return List.of(
        new Project("portfolio-website", "Portfolio Website",
            "Spring Boot + Thymeleaf portfolio site with reusable layout and Bootstrap UI.",
            List.of("Java", "Spring Boot", "Thymeleaf", "Bootstrap"),
            "https://github.com/ArturMK98/portfolio-website"
        ),
        new Project("canvaslite-poc", "CanvasLite (POC)",
            "Proof-of-concept web app focused on core flows and clean MVC structure.",
            List.of("Spring MVC", "Bootstrap", "POC"),
            ""
        )
    );
}


}
