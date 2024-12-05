package com.javaacademy.homework_autosale.repository;

import com.javaacademy.homework_autosale.entity.Announcement;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Репозиторий объявлений
 */
@Component
public class AnnouncementRepository {
    public Map<Integer, Announcement> announcementMap = new HashMap<>();

    /**
     * Добавление нового объявления
     *
     * @param announcement объявление
     */
    public void save(Announcement announcement) {
        announcementMap.put(announcement.getId(), announcement);
    }

    /**
     * Выбор объявления по идентификатору
     *
     * @param id идентификатор
     * @return объявление
     */
    public Announcement getById(Integer id) {
        return announcementMap.get(id);
    }

    /**
     * Выбор всех объявлений
     *
     * @return Список всех объявлений
     */
    public List<Announcement> getAll() {
        return announcementMap.values().stream().toList();
    }

    /**
     * Удаление объявления по идентификатору
     *
     * @param id идентификатор
     * @return результат объявления (true если удачно)
     */
    public boolean deleteById(Integer id) {
        return announcementMap.remove(id) != null;
    }
}
