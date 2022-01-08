package com.frizerii.protorype.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users", schema = "public")
@ToString
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "accessTokenInstagram")
    private String accessTokenInstagram;

//    @OneToMany(mappedBy = "userFk", cascade = CascadeType.ALL,
//            orphanRemoval = true, fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private List<EventEntity> events;
//
//    @OneToOne(mappedBy = "userFk", cascade = CascadeType.ALL,
//            orphanRemoval = true, fetch = FetchType.LAZY)
//    private SettingsInstagramEntity settingsInstagram;
//
//    @OneToOne(mappedBy = "userFk", cascade = CascadeType.ALL,
//            orphanRemoval = true, fetch = FetchType.LAZY)
//    private StatusEntity status;
}
