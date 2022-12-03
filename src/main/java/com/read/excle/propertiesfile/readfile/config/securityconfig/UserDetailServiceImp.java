package com.read.excle.propertiesfile.readfile.config.securityconfig;


import com.read.excle.propertiesfile.readfile.model.User;
import com.read.excle.propertiesfile.readfile.model.UserRoleToPrivilege;
import com.read.excle.propertiesfile.readfile.model.UserToRole;
import com.read.excle.propertiesfile.readfile.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDetailServiceImp implements UserDetailsService {
UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.findByMail(s);
        if (user == null) {
            throw new UsernameNotFoundException("User with username [" + s + "] not found in the system");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (UserToRole userToRole : user.getUserToRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userToRole.getRole().getRoleName()));
            for (UserRoleToPrivilege userRoleToPrivilege : userToRole.getRole().getUserRoleToPrivilegeList()) {
                authorities.add(new SimpleGrantedAuthority(userRoleToPrivilege.getPrivilege().getPrivilegeName()));
            }

        }
        return new  ApplicationUser(user.getAccountName(),passwordEncoder.encode(user.getPassword()),authorities,
                user.isAccountNonExpired(),user.isAccountNonLocked(),user.isCredentialsNonExpired(),user.isEnabled());
    }
}
