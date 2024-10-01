package com.gabreudev.TemVaga_API.servecies;

import com.gabreudev.TemVaga_API.entities.Announcement.Announcement;
import com.gabreudev.TemVaga_API.entities.Announcement.AnnouncementDTO;
import com.gabreudev.TemVaga_API.entities.Announcement.CreateAnnouncementDTO;
import com.gabreudev.TemVaga_API.entities.User;
import com.gabreudev.TemVaga_API.repositories.AnnouncementRepository;
import com.gabreudev.TemVaga_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public AnnouncementDTO createAnnouncement(CreateAnnouncementDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Announcement announcement = new Announcement();
        announcement.setTitle(dto.title());
        announcement.setDescription(dto.description());
        announcement.setUser(user);

        announcementRepository.save(announcement);

        return new AnnouncementDTO(
                announcement.getId(),
                announcement.getTitle(),
                announcement.getDescription(),
                user.getId()
        );
    }

    @Transactional(readOnly = true)
    public List<AnnouncementDTO> getAllAnnouncements() {
        return announcementRepository.findAll().stream()
                .map(announcement -> new AnnouncementDTO(
                        announcement.getId(),
                        announcement.getTitle(),
                        announcement.getDescription(),
                        announcement.getUser().getId()
                ))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AnnouncementDTO getAnnouncementById(UUID id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anúncio não encontrado"));
        return new AnnouncementDTO(
                announcement.getId(),
                announcement.getTitle(),
                announcement.getDescription(),
                announcement.getUser().getId()
        );
    }

    @Transactional
    public void deleteAnnouncement(UUID id) {
        announcementRepository.deleteById(id);
    }
}
