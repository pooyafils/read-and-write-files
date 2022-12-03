package com.read.excle.propertiesfile.readfile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false) //throw error maybe
    private int id;
    private String accountName;
    private String mail;
    private String password;
    private boolean  enabled;
    private  boolean isAccountNonExpired;
    private  boolean isAccountNonLocked;
    private  boolean isCredentialsNonExpired;
    @JsonIgnore
    private String verificationCode;
    @OneToMany(mappedBy = "user")
    private List<UserToRole> userToRoles;
    private Instant modifyTime=Instant.now();
    private UUID userId;



}
