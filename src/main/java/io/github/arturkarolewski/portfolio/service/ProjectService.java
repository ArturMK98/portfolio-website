package io.github.arturkarolewski.portfolio.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.arturkarolewski.portfolio.model.Project;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ProjectService {

    // Keep it local; this app doesn't need a shared mapper or extra config.
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Project> getProjects() {
        // Read the JSON on each call so updates in the file show up on refresh.
        try (InputStream in = new ClassPathResource("data/projects.json").getInputStream()) {
            return objectMapper.readValue(in, new TypeReference<List<Project>>() {});
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load data/projects.json", e);
        }
    }

    public Project getBySlug(String slug) {
        // Small list, simple stream is fine here.
        return getProjects().stream()
                .filter(p -> p.slug().equals(slug))
                .findFirst()
                .orElse(null);
    }
}
