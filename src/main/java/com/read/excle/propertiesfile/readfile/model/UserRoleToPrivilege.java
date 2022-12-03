package com.read.excle.propertiesfile.readfile.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserRoleToPrivilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private UserRole role;
    @ManyToOne
    private UserPrivilege privilege;
}
