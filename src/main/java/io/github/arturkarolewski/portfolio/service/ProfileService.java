package io.github.arturkarolewski.portfolio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.arturkarolewski.portfolio.model.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ProfileService {

    // Simple JSON -> POJO mapping, no special config needed.
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Profile getProfile() {
        // Content in data/profile.json.
        try (InputStream in = new ClassPathResource("data/profile.json").getInputStream()) {
            return objectMapper.readValue(in, Profile.class);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load data/profile.json", e);
        }
    }
}
