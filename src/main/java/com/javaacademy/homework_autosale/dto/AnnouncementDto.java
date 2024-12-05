package com.javaacademy.homework_autosale.dto;

import com.javaacademy.homework_autosale.Brand;
import com.javaacademy.homework_autosale.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO - данные из запроса
 */
@Data
@AllArgsConstructor
public class AnnouncementDto {
    private Brand brand;
    private Color color;
    private BigDecimal price;

}