package com.read.excle.propertiesfile.readfile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class UserToRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@JsonIgnore
    @ManyToOne
    User user;
@JsonIgnore
    @ManyToOne
    private UserRole role;
}
