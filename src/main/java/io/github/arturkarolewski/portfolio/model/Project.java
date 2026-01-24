package io.github.arturkarolewski.portfolio.model;

import java.util.List;

public record Project(
        String slug,
        String title,
        String description,
        String longDescription,
        List<String> tags,
        List<String> features,
        String url,
        String demoUrl,
        String image,
        String year
) {}
