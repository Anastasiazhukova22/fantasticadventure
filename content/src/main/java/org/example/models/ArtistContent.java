package org.example.models;

import java.time.LocalDate;

public record ArtistContent(
        Integer contentId,
        String title,
        String description,
        String contentType,
        String contentUrl,
        String status,
        LocalDate publicationDate,
        LocalDate archiveDate,
        String editorNotes,
        Integer priorityLevel,
        String contentAccessLevel) {
}

