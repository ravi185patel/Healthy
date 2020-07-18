package com.example.serviceImp;

import com.example.dao.UsersDao;
import com.example.entity.Role;
import com.example.entity.Users;
import com.example.mapper.MapperInterface;
import com.example.model.UsersModel;
import com.example.service.UsersServiceI;
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
public class UserDetailsServiceImpl implements UserDetailsService , UsersServiceI<UsersModel> {

    @Autowired
    private MapperInterface<UsersModel, Users> usersMapper;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users=usersDao.find(userName);
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
        return usersDao.isUsernameAlreadyInUse(username);
    }

    public boolean isEmailAlreadyInUse(String emaildId){
        return usersDao.isEmailAlreadyInUse(emaildId);
    }

    public Users saveUser(Users user){
        return usersDao.save(user);
    }

    @Override
    public UsersModel add(UsersModel usersModel) {
        return usersMapper.entityToModel(usersDao.save(usersMapper.modelToEntity(usersModel)));
    }

    @Override
    public UsersModel update(UsersModel usersModel) {
        return null;
    }

    @Override
    public UsersModel get(Long id) {
        return null;
    }

    @Override
    public UsersModel get(String email) {
        return usersMapper.entityToModel(usersDao.findByUserName(email));
    }

    @Override
    public List<UsersModel> getAll() {
        return null;
    }
}