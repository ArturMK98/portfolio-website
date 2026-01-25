package io.github.arturkarolewski.portfolio.model;

import java.util.List;

public record Profile(
        String name,
        String title,
        String bio,
        String location,
        Social social,
        List<String> skills
) {
    // Links are grouped under Social for a tidy JSON shape.
    public record Social(
            String github,
            String linkedin,
            String email
    ) {}
    // Record matches the structure of data/profile.json.
}
