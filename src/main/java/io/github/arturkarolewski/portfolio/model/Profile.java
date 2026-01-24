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
    public record Social(
            String github,
            String linkedin,
            String email
    ) {}
}
