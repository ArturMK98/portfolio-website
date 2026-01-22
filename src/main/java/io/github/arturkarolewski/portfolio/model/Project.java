package io.github.arturkarolewski.portfolio.model;

import java.util.List;

public record Project(
        String slug,
        String title,
        String description,
        List<String> tags,
        String url,
        String image
) {}
