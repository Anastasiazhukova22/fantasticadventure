package org.example.controllers;

import com.google.protobuf.Int32Value;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.stubs.AddContentRequest;
import org.example.stubs.AddContentResponse;
import org.example.stubs.ContentRequest;
import org.example.stubs.ContentResponse;
import org.example.stubs.ContentServiceGrpc;

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

    @Override
    public void addContent(AddContentRequest request, StreamObserver<AddContentResponse> responseObserver) {
        String title = request.getTitle();
        String description = request.getDescription();
        String contentType = request.getContentType();
        String contentUrl = request.getContentUrl();
        String status = request.getStatus();
        int priorityLevel = request.getPriorityLevel();
        String contentAccessLevel = request.getContentAccessLevel();

        int generatedId = generateId();

        AddContentResponse response = AddContentResponse.newBuilder()
                .setId(generatedId)
                .setMessage("data is published")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private int generateId() {
        return 12345;
    }

}

