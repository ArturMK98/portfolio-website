package io.github.arturkarolewski.portfolio.model;

import java.util.List;

public record Cv(
        String summary,
        List<Experience> experience,
        List<Education> education,
        List<String> certifications,
        List<Language> languages
) {
    public record Experience(
            String title,
            String company,
            String location,
            String startDate,
            String endDate,
            String description,
            List<String> highlights
    ) {}

    public record Education(
            String degree,
            String institution,
            String location,
            String startDate,
            String endDate,
            String description
    ) {}

    public record Language(
            String name,
            String level
    ) {}
    // Record matches the structure of data/cv.json.
}
