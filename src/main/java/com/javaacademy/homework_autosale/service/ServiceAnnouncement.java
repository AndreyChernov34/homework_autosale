package com.javaacademy.homework_autosale.service;

import com.javaacademy.homework_autosale.Brand;
import com.javaacademy.homework_autosale.Color;
import com.javaacademy.homework_autosale.dto.AnnouncementDto;
import com.javaacademy.homework_autosale.entity.Announcement;
import com.javaacademy.homework_autosale.repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Класс Сервис объявлений
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceAnnouncement {
    private Integer counter = 0;
    private final AnnouncementRepository announcementRepository;

    /**
     * Создание нового объявления
     *
     * @param announcementDto данные из JSON
     */
    public void save(AnnouncementDto announcementDto) {
        counter++;
        Announcement announcement = new Announcement(counter, announcementDto.getBrand(), announcementDto.getColor(),
                announcementDto.getPrice());
        announcementRepository.save(announcement);
        log.info(announcement.toString());
    }

    /**
     * Поиск объявления по идентификатору
     *
     * @param id идентификатор
     * @return объявление
     */
    public Announcement getById(Integer id) {
        return announcementRepository.getById(id);


    }

    /**
     * Поиск всех объявлений
     *
     * @return список всех объявлений
     */
    public List<Announcement> getAll() {
        if (!announcementRepository.getAll().isEmpty()) {
            return announcementRepository.getAll();
        } else {
            throw new RuntimeException("Объявлений нет");
        }
    }

    /**
     * Удаление объявления по идентификатору
     *
     * @param id идентификатор
     * @return результат удаления (true если успешно)
     */
    public boolean deleteById(Integer id) {
        return announcementRepository.deleteById(id);
    }

    /**
     * Поиск объявлений по параметрам
     *
     * @param brand бренд авто
     * @param color цвет авто
     * @param price цена авто
     * @return список объявлений с запрашиваемыми параметрами
     */
    public List<Announcement> getByParams(Brand brand, Color color,
                                          BigDecimal price) {
        return announcementRepository.getAll().stream()
                .filter(announcement -> (brand == null || announcement.getBrand() == brand))
                .filter(announcement -> (color == null || announcement.getColor() == color))
                .filter(announcement -> (price == null || (announcement.getPrice().compareTo(price)) == 0))
                .toList();
    }
}
