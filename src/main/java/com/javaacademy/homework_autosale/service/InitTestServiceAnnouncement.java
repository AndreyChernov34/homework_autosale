package com.javaacademy.homework_autosale.service;

import com.javaacademy.homework_autosale.Brand;
import com.javaacademy.homework_autosale.Color;
import com.javaacademy.homework_autosale.dto.AnnouncementDto;
import com.javaacademy.homework_autosale.repository.AnnouncementRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Заполнение тестовыми объявлениями
 */
@Component
@Profile("test")
@RequiredArgsConstructor
@Slf4j
public class InitTestServiceAnnouncement {
    private static final BigDecimal PRICE1 = BigDecimal.valueOf(750000);
    private static final BigDecimal PRICE2 = BigDecimal.valueOf(1500000);
    private static final BigDecimal PRICE3 = BigDecimal.valueOf(3550000);

    private final ServiceAnnouncement serviceAnnouncement;
    private final AnnouncementRepository announcementRepository;

    @PostConstruct
    public void init() {
        saveDto(Brand.FORD, Color.BLACK, PRICE1);
        saveDto(Brand.BMW, Color.BLACK, PRICE2);
        saveDto(Brand.BMW, Color.WHITE, PRICE3);
        saveDto(Brand.KIA, Color.WHITE, PRICE1);
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setBrand(Brand.BMW);
        serviceAnnouncement.save(announcementDto);
    }

    public void saveDto(Brand brand, Color color, BigDecimal price) {
        AnnouncementDto announcementDto = new AnnouncementDto(brand, color, price);
        serviceAnnouncement.save(announcementDto);
    }

}

