package com.aicap.springbootwebapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "lastname")
    private String lastName;

    @NotBlank(message =  "email cannot be blank")
    @NonNull
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank(message =  "password cannot be blank")
    @NonNull
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Event> eventsOrganized;

    @JsonIgnore
    @ManyToMany(mappedBy = "participants")
    private List<Event> eventList;

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
