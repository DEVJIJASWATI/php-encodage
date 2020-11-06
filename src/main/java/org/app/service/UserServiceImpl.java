package org.app.service;

import org.app.model.Role;
import org.app.model.User;
import org.app.repository.RoleRepository;
import org.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    public UserServiceImpl(UserRepository userRepository , RoleRepository roleRepository , BCryptPasswordEncoder bCryptPasswordEncoder){
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new ArrayList<>(roleRepository.findAll()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

//    public User save(String nom , String prenom, int age , String matricule , String password , String passwordConfirm) {
//        User user = userRepository.findByMatricule(matricule);
//        if (user != null ) new RuntimeException("Utilisateur existe deja");
//        if (password.equals(passwordConfirm)) throw new RuntimeException("Mot de passe non identique");
//
//        User users = new User();
//        users.setNom(nom);
//        users.setPrenom(prenom);
//        users.setAge(age);
//        users.setMatricule(matricule);
//        users.setPassword(bCryptPasswordEncoder.encode(password));
//        userRepository.save(users);
//        addRoleToUser(matricule, "USER");
//        return users;
//    }
//
//    public void addRoleToUser(String matricule, String role_name) {
//        User user = userRepository.findByMatricule(matricule);
//        Role role = roleRepository.findByRole_name(role_name);
//        user.getRoles().add(role);
//    }
//
//
//    @Override
//    public void save(User user) {
//
//    }

    @Override
    public User findByMatricule(String matricule) {
        return userRepository.findByMatricule(matricule);
    }
}
