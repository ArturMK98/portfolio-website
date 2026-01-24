package io.github.arturkarolewski.portfolio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.arturkarolewski.portfolio.model.About;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class AboutService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public About getAbout() {
        try (InputStream in = new ClassPathResource("data/about.json").getInputStream()) {
            return objectMapper.readValue(in, About.class);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load data/about.json", e);
        }
    }
}
