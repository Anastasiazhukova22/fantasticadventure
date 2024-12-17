package org.example.mappers;

import org.example.dto.ArtistContent;
import org.example.dto.ArtistContentDto;

import java.util.Random;

public class ArtistMapper {
    public static ArtistContent map(ArtistContentDto dto) {
       return new ArtistContent(new Random().nextInt(),
               dto.title(),
               dto.description(),
               dto.contentType(),
               dto.contentUrl(),
               dto.status(),
               dto.publicationDate(),
               dto.archiveDate(),
               dto.editorNotes(),
               dto.priorityLevel(),
               dto.contentAccessLevel());

    }

}
