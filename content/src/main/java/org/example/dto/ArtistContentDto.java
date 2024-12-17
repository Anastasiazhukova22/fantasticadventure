package org.example.dto;

import java.time.LocalDate;

public record ArtistContentDto(
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
