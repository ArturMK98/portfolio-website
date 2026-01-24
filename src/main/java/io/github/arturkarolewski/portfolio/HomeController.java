package io.github.arturkarolewski.portfolio;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import io.github.arturkarolewski.portfolio.model.Project;
import io.github.arturkarolewski.portfolio.service.ProjectService;

@Controller
public class HomeController {

    private final ProjectService projectService;


    @GetMapping("/")
    public String home(Model model) {
        List<Project> projects = projectService.getProjects();
        model.addAttribute("featured", projects.stream().limit(2).toList());
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/projects/{slug}")
    public String projectDetail(@PathVariable String slug, Model model) {
        Project project = projectService.getBySlug(slug);

        if (project == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        model.addAttribute("project", project);
        return "project-detail";
}

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", projectService.getProjects());
        return "projects";
    }


    public HomeController(ProjectService projectService) {
        this.projectService = projectService;
    }
}
