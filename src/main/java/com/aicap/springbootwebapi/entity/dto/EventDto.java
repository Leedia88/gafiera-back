package com.aicap.springbootwebapi.entity.dto;

import com.aicap.springbootwebapi.entity.Category;

import java.time.LocalDate;

public class EventDto {

    private String title;
    private String description;
    private LocalDate date;
    private Integer duration;
    private String place;
    private Long owner;
    private Long category;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getDuration() {
        return duration;
    }

    public Long getOwner() {
        return owner;
    }

    public Long getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", owner='" + owner + '\'' +
                ", category=" + category +
                '}';
    }
}
