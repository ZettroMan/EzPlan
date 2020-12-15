package ru.gb.zettro.ezplan.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.zettro.ezplan.entities.User;
import ru.gb.zettro.ezplan.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
