package com.javaacademy.homework_autosale.entity;

import com.javaacademy.homework_autosale.Brand;
import com.javaacademy.homework_autosale.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Сущность объявление
 */
@Data
@AllArgsConstructor
public class Announcement {
    private Integer id;
    private Brand brand;
    private Color color;
    private BigDecimal price;
}
