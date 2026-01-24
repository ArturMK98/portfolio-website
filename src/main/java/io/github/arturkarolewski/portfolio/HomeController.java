package io.github.arturkarolewski.portfolio;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.arturkarolewski.portfolio.model.Project;
import io.github.arturkarolewski.portfolio.service.ProjectService;
import io.github.arturkarolewski.portfolio.service.ProfileService;
import io.github.arturkarolewski.portfolio.service.CvService;

@Controller
public class HomeController {

    private final ProjectService projectService;
    private final ProfileService profileService;
    private final CvService CvService;

    public HomeController(ProjectService projectService, ProfileService profileService, CvService CvService) {
        this.projectService = projectService;
        this.profileService = profileService;
        this.CvService = CvService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Project> projects = projectService.getProjects();
        model.addAttribute("featured", projects.stream().limit(2).toList());
        model.addAttribute("profile", profileService.getProfile());
        return "index";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("profile", profileService.getProfile());
        return "contact";
    }

    @GetMapping("/projects/{slug}")
    public String projectDetail(@PathVariable String slug, Model model) {
        Project project = projectService.getBySlug(slug);

        if (project == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        model.addAttribute("project", project);
        model.addAttribute("profile", profileService.getProfile());
        return "project-detail";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", projectService.getProjects());
        model.addAttribute("profile", profileService.getProfile());
        return "projects";
    }

    @GetMapping("/cv")
    public String cv(Model model) {
        model.addAttribute("cv", CvService.getCv());
        model.addAttribute("profile", profileService.getProfile());
        return "cv";
    }
}
