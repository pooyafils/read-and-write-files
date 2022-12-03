package com.read.excle.propertiesfile.readfile.repository;

import com.read.excle.propertiesfile.readfile.model.UserToRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToRoleRepository extends JpaRepository<UserToRole,Integer> {
}
