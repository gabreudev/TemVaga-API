package com.gabreudev.TemVaga_API.controllers;

import com.gabreudev.TemVaga_API.entities.Announcement.AnnouncementDTO;
import com.gabreudev.TemVaga_API.entities.Announcement.CreateAnnouncementDTO;
import com.gabreudev.TemVaga_API.servecies.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@RequestBody CreateAnnouncementDTO dto) {
        AnnouncementDTO announcement = announcementService.createAnnouncement(dto);
        return ResponseEntity.ok(announcement);
    }

    @GetMapping
    public ResponseEntity<List<com.gabreudev.TemVaga_API.entities.Announcement.AnnouncementDTO>> getAllAnnouncements() {
        List<AnnouncementDTO> announcements = announcementService.getAllAnnouncements();
        return ResponseEntity.ok(announcements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncementById(@PathVariable UUID id) {
        AnnouncementDTO announcement = announcementService.getAnnouncementById(id);
        return ResponseEntity.ok(announcement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable UUID id) {
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.noContent().build();
    }
}
