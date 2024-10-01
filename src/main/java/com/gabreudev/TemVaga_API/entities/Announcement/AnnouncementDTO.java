package com.gabreudev.TemVaga_API.entities.Announcement;

import java.util.UUID;

public record AnnouncementDTO(
        UUID id,
        String title,
        String description,
        UUID userId
) {
}
