package com.aicap.springbootwebapi.service;

import com.aicap.springbootwebapi.dao.UserDao;
import com.aicap.springbootwebapi.entity.Event;
import com.aicap.springbootwebapi.entity.User;
import com.aicap.springbootwebapi.entity.dto.LoginDto;
import com.aicap.springbootwebapi.entity.dto.UserDto;
import com.aicap.springbootwebapi.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userdao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User getUser(Long id) {
        Optional<User> option = userdao.findById(id);
        return unwrapUser(option, id);
    }

    @Override
    public User getUser(String email) {
        Optional<User> option = userdao.findByEmail(email);
        return unwrapUser(option, 404L) ;
    }

    @Override
    public User getLoggedUser(LoginDto loginDto) {
        Optional<User> option = userdao.findByEmail(loginDto.getEmail());
        return unwrapUser(option, 404L);
    }

    @Override
    public User saveUser(UserDto userDto) {
        String password = bCryptPasswordEncoder.encode(userDto.getPassword());
        User user = new User(userDto.getName(), userDto.getLastName(), userDto.getEmail(), password);
        return userdao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userdao.findAll();
    }

    @Override
    public User updateUser(Long id, UserDto userDto) {
        Optional<User> option = userdao.findById(id);
        User user = unwrapUser(option, id);
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        return userdao.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userdao.deleteById(id);
    }

    @Override
    public List<Event> getEnrolledEvents(Long user_id) {
        User user = getUser(user_id);
        return user.getEventList();
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }



}
