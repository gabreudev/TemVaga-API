package com.gabreudev.TemVaga_API.entities.Announcement;

import java.util.UUID;

public record CreateAnnouncementDTO(
        String title,
        String description,
        UUID userId) {
}
