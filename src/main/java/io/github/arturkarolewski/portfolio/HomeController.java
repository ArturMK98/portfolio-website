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
import io.github.arturkarolewski.portfolio.service.AboutService;

@Controller
public class HomeController {

    // Services are thin wrappers around JSON data files on the classpath.
    private final ProjectService projectService;
    private final ProfileService profileService;
    private final CvService cvService;
    private final AboutService aboutService;

    public HomeController(ProjectService projectService, ProfileService profileService, CvService cvService, AboutService aboutService) {
        this.projectService = projectService;
        this.profileService = profileService;
        this.cvService = cvService;
        this.aboutService = aboutService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Home page shows the two most recent/featured projects.
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
        // Project pages are addressed by slug from the JSON file.
        Project project = projectService.getBySlug(slug);

        if (project == null) {
            // Bubble up a 404 so the error page handles missing projects.
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
        // This pulls from data/cv.json.
        model.addAttribute("cv", cvService.getCv());
        model.addAttribute("profile", profileService.getProfile());
        return "cv";
    }

    @GetMapping("/about")
    public String about(Model model) {
        // Personal bio, content in data/about.json.
        model.addAttribute("about", aboutService.getAbout());
        model.addAttribute("profile", profileService.getProfile());
        return "about";
    }
}
