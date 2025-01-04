package org.example.controllers;

import com.google.protobuf.Int32Value;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.stubs.*;

import javax.annotation.processing.Generated;

import java.util.ArrayList;
import java.util.List;

import static com.google.protobuf.Timestamp.*;

@GrpcService
public class GrpcContentService extends ContentServiceGrpc.ContentServiceImplBase {

    private final ArtistController controller;

    public GrpcContentService(ArtistController controller) {
        this.controller = controller;
    }

    @Override
    public void getContent(ContentRequest request, StreamObserver<ContentResponse> responseObserver) {
        ContentResponse contentResponse = controller.contentList.stream().filter(c -> c.contentId() == request.getGeneratedId())
                .findAny().map(c -> ContentResponse.newBuilder() //get добавить свой контент лист на grpc
                        .setTitle(c.title())
                        .setDescription(c.description())
                        .setContentType(c.contentType())
                        .setContentUrl(c.contentUrl())
                        .setStatus(c.status())
                        //todo set timestamps 
                        .setPublicationDate(newBuilder().build())
                        .setArchiveDate(newBuilder().build())
                        .setEditorNotes(c.editorNotes() == null ? "" : c.editorNotes())
                        .setPriorityLevel(c.priorityLevel())
                        .setContentAccessLevel(c.contentAccessLevel())
                        .build()
                ).orElseThrow();
        responseObserver.onNext(contentResponse);
        responseObserver.onCompleted();
    }

    private final List<Content> contentStorage = new ArrayList<>();

    @Override
    public void addContent(AddContentRequest request, StreamObserver<AddContentResponse> responseObserver) {
        String title = request.getTitle();
        String description = request.getDescription();
        String contentType = request.getContentType();
        String contentUrl = request.getContentUrl();
        String status = request.getStatus();
        int priorityLevel = request.getPriorityLevel();
        String contentAccessLevel = request.getContentAccessLevel();

        int generatedId = generatedId();

        Content content = new Content(generatedId, title, description, contentType, contentUrl, status, priorityLevel, contentAccessLevel);
        contentStorage.add(content);

        AddContentResponse response = AddContentResponse.newBuilder()
                .setId(generatedId)
                .setMessage("data is published")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private int generatedId() {
        return contentStorage.size() + 1;
    }

    private static class Content {
        int id;
        String title;
        String description;
        String contentType;
        String contentUrl;
        String status;
        int priorityLevel;
        String contentAccessLevel;

        public Content(int id, String title, String description, String contentType, String contentUrl, String status, int priorityLevel, String contentAccessLevel) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.contentType = contentType;
            this.contentUrl = contentUrl;
            this.status = status;
            this.priorityLevel = priorityLevel;
            this.contentAccessLevel = contentAccessLevel;
        }
    }
}


