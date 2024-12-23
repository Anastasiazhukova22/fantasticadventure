package org.example.controllers;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
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
        ContentResponse contentResponse = controller.contentList.stream().filter(c -> c.contentId() == request.getId())
                .findAny().map(c -> ContentResponse.newBuilder()
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
}
