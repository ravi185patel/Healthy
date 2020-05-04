package com.example.serviceImp;

import com.example.entity.Role;
import com.example.entity.Users;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users=usersRepository.findByUserName(userName).get();
        if(users==null){
            users=new Users();
            users.setUserName("ravidpatel");
            users.setPassword("ravi1990");
        }
        System.out.println(users.getUserName()+" "+users.getPassword());
//        users.getRoles().forEach(s->System.out.println(s.getRoleName()));
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));//usersRepository.findByUserName(userName).get();
        List<GrantedAuthority> authorities = getUserAuthority(users.getRoles());
//        System.out.println(users.getUserName()+" "+users.getPassword());
        return buildUserForAuthentication(users, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        if(userRoles.isEmpty()){
            roles.add(new SimpleGrantedAuthority("ADMIN"));
        }else{
            for (Role role : userRoles) {
                roles.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }
        roles.forEach(s->System.out.println(s.getAuthority()));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Users users, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(users.getUserName(), users.getPassword(),
                true, true, true, true, authorities);
    }

    public boolean isUsernameAlreadyInUse(String username){
        Optional<Users> users=usersRepository.findByUserName(username);
        return users.isPresent();
    }
}