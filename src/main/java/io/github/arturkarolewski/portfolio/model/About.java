package io.github.arturkarolewski.portfolio.model;

public record About(
        String photo,
        String introduction,
        String whatIDo,
        String interests
) {
    // Record matches the structure of data/about.json.
}
