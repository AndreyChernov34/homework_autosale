package com.javaacademy.homework_autosale.controllers;

import com.javaacademy.homework_autosale.announcement.Announcement;
import com.javaacademy.homework_autosale.service.SericeAnnouncement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("checkstyle:RegexpSingleline")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auto")
public class AutoController {
    SericeAnnouncement sericeAnnouncement;

    @PostMapping()
    public void saveAuto(@RequestBody Announcement announcement) {
        sericeAnnouncement.save(announcement);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Announcement getAuto(@PathVariable Integer id) {
        return sericeAnnouncement.getById(id).orElseThrow();
    }

    @GetMapping
    public List<Announcement> getAllAuto() {
        return sericeAnnouncement.getAll().orElseThrow();
    }

    @DeleteMapping
    public boolean deleteAuto(Integer id) {
        return sericeAnnouncement.deleteById(id);
    }


}


