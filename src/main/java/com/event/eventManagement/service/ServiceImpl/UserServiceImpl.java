package com.event.eventManagement.service.ServiceImpl;

import com.event.eventManagement.entity.User;
import com.event.eventManagement.repository.UserRepository;
import com.event.eventManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User u){
       if(userRepository.existsByEmail(u.getEmail())){
           throw new RuntimeException("User already exists");
       }
         u.setPassword(passwordEncoder.encode(u.getPassword()));
       return userRepository.save(u);

    }

    @Override
    public User getUserById(Long id){
       return (userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found")));
    }

    @Override
    public User updateUserById(User user,Long id) {
        User u = getUserById(id);
        if(user.getEmail()!=null) u.setEmail(user.getEmail());
        if(user.getName()!=null) u.setName(user.getName());
        if (user.getPassword()!=null) u.setPassword(user.getPassword());

        return userRepository.save(u);
    }

    @Override
    public void deleteUserById(Long id) {
        getUserById(id);
        userRepository.deleteById(id);
    }

}
