package com.example.student_library_management_system.enums;

public enum AuthorRating {
    ONE_STAR(1),
    TWO_STAR(2),
    THREE_STAR(3),
    FOUR_STAR(4),
    FIVE_STAR(5);

    private final int rating;

    AuthorRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
