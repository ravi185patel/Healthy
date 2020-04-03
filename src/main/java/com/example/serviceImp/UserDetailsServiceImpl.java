package com.example.serviceImp;

import com.example.entity.Role;
import com.example.entity.Users;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println(" username loadbyusername -> "+userName);
        Users users = new Users();
        users.setUserName("ravi");
        users.setPassword(bCryptPasswordEncoder.encode("ravi1990"));//usersRepository.findByUserName(userName).get();
        List<GrantedAuthority> authorities = getUserAuthority(users.getRoles());
        return buildUserForAuthentication(users, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
//        for (Role role : userRoles) {
//            roles.add(new SimpleGrantedAuthority(role.getRoleName()));
            roles.add(new SimpleGrantedAuthority("ADMIN"));
//        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Users users, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(users.getUserName(), users.getPassword(),
                users.getIsActive() ==0, true, true, true, authorities);
    }
}