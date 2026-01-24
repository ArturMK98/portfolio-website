package io.github.arturkarolewski.portfolio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.arturkarolewski.portfolio.model.Cv;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class CvService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Cv getCv() {
        try (InputStream in = new ClassPathResource("data/cv.json").getInputStream()) {
            return objectMapper.readValue(in, Cv.class);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load data/cv.json", e);
        }
    }
}
