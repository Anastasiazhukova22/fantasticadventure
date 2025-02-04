package org.example.models;

public record Content(int id, String title, String description, String contentType, String contentUrl, String status, int priorityLevel, String contentAccessLevel) {
    }
