package com.javaacademy.homework_autosale.announcement;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Сущность объявление
 */
@Data
public class Announcement {
    private Integer id;
    private String brand;
    private String color;
    private BigDecimal price;

}
