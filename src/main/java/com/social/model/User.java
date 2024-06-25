package com.social.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name="User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String location;

    private String website;

    private String birthDate;

    private String email;

    private String password;

    private String mobile;

    private String image;

    private String backroundImage;

    private String bio;

    private boolean req_user;

    private boolean login_with_google;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Twit> twit = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @Embedded
    private Varification verification;

    @JsonIgnore
    @ManyToMany
    private List<User>followers = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    private List<User>followings = new ArrayList<>();
}

