package com.example.restdemo.service;

import com.example.restdemo.entity.User;
import com.example.restdemo.exception.UserNotFoundException;
import com.example.restdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDefaultService implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> update(int id, User newUser) {
        checkIfUserExists(id);

        return userRepository.findById(id).map(user -> {
            user.setFirstname(newUser.getFirstname());
            user.setLastname(newUser.getLastname());
            user.setAge(newUser.getAge());
            return userRepository.save(user);
        });
    }

    @Override
    public void delete(int id) {
        checkIfUserExists(id);

        userRepository.deleteById(id);
    }

    private void checkIfUserExists(int id) throws UserNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Could not find user");
        }

    }

}
