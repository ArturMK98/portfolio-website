package io.github.arturkarolewski.portfolio.service;

import io.github.arturkarolewski.portfolio.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    public List<Project> getProjects() {
        return List.of(
            new Project(
                "portfolio-website",
                "Portfolio Website",
                "Spring Boot + Thymeleaf portfolio site with reusable layout and Bootstrap UI.",
                List.of("Java", "Spring Boot", "Thymeleaf", "Bootstrap"),
                "https://github.com/ArturMK98/portfolio-website",
                "/img/portfolio.png"
            ),
            new Project(
                "canvaslite-poc",
                "CanvasLite (POC)",
                "Proof-of-concept web app focused on core flows and clean MVC structure.",
                List.of("Spring MVC", "Bootstrap", "POC"),
                "",
                "/img/canvaslite_temp.png"
            )
        );
    }

    public Project getBySlug(String slug) {
        return getProjects().stream()
                .filter(p -> p.slug().equals(slug))
                .findFirst()
                .orElse(null);
    }
}
