package com.javaacademy.homework_autosale.service;

import com.javaacademy.homework_autosale.announcement.Announcement;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class SericeAnnouncement {
    private Integer counter = 0;
    public Map<Integer, Announcement> announcementMap = new HashMap<>();

    public void save(Announcement announcement) {
        counter++;
        announcement.setId(counter);
        announcementMap.put(announcement.getId(), announcement);
    }

    public Optional<Announcement> getById (Integer id) {
        if (announcementMap.containsKey(id)) {
            return Optional.ofNullable(announcementMap.get(id));
        } else {
            throw new RuntimeException("Нет объявления с таким id");
        }
    }

    public Optional<List<Announcement>> getAll () {
        if (!announcementMap.isEmpty()) {
            return Optional.ofNullable(announcementMap.values().stream().toList());
        } else {
            throw new RuntimeException("Объявлений нет");
        }
    }

    public boolean deleteById(Integer id) {
        return announcementMap.remove(id) != null;
    }



}
