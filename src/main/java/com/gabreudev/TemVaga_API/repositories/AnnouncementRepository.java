package com.gabreudev.TemVaga_API.repositories;

import com.gabreudev.TemVaga_API.entities.Announcement.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnnouncementRepository extends JpaRepository<Announcement, UUID> {
}
