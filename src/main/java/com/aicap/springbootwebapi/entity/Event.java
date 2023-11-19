package com.aicap.springbootwebapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "start_date")
    private LocalDate date;
    private Integer duration;
//    private attendees;

    private String place;

    @ManyToOne(optional = false)
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @ManyToMany
    @JoinTable(name = "attendance",
            joinColumns = @JoinColumn(name = "event_id"), //nom qu'on donne à la colonne pour mieux relier
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> participants;

    public Event(String title, String description, LocalDate date, Integer duration, User owner, Category category) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.duration = duration;
        this.category = category;
        this.owner = owner;
    }
}

