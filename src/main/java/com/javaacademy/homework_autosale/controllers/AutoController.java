package com.javaacademy.homework_autosale.controllers;

import com.javaacademy.homework_autosale.Brand;
import com.javaacademy.homework_autosale.Color;
import com.javaacademy.homework_autosale.dto.AnnouncementDto;
import com.javaacademy.homework_autosale.entity.Announcement;
import com.javaacademy.homework_autosale.service.ServiceAnnouncement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * Контроллер
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/auto")
@Slf4j
public class AutoController {
    private final ServiceAnnouncement serviceAnnouncement;

    /**
     * Добавление нового авто
     *
     * @param announcementDto считанные данные из json
     */
    @PostMapping()
    public void saveAuto(@RequestBody AnnouncementDto announcementDto) {
        serviceAnnouncement.save(announcementDto);
    }

    /**
     * Запрос по идентификатору
     *
     * @param id идентификатор объявления
     * @return Объявление
     */
    @RequestMapping("/{id}")
    public Announcement getAutobyId(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        return serviceAnnouncement.getById(id);
    }

    /**
     * Запрос всех объявлений
     *
     * @return Список всех объявлений
     */
    @GetMapping
    public List<Announcement> getAllAuto() {
        log.info("getall");
        return serviceAnnouncement.getAll();
    }

    /**
     * Удаление объявления по идентификатору
     *
     * @param id идентификатор объявления
     * @return True если удаление произошло, false если не произошло
     */
    @DeleteMapping("/{id}")
    public boolean deleteAuto(@PathVariable Integer id) {
        return serviceAnnouncement.deleteById(id);
    }

    /**
     * Поиск объявлений по нескольким параметрам
     *
     * @param brand Бренд авто
     * @param color Цвет авто
     * @param price Цена авто
     * @return Список объявлений, с заданными параметрами
     */
    @GetMapping("/search")
    public List<Announcement> getAutoByParams(@RequestParam(required = false) Brand brand,
                                              @RequestParam(required = false) Color color,
                                              @RequestParam(required = false) BigDecimal price) {

        return serviceAnnouncement.getByParams(brand, color, price);
    }


}


