package com.dailyhaul.user.service.impl;

import com.dailyhaul.user.dto.UserRequest;
import com.dailyhaul.user.dto.UserResponse;
import com.dailyhaul.user.model.User;
import com.dailyhaul.user.repository.UserRepository;
import com.dailyhaul.user.service.UserService;
import com.dailyhaul.user.utils.Mappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(Mappers::getUserResponse)
                .collect(Collectors.toList());
    }

    public void addUser(UserRequest userRequest) {
        User user = new User();
        Mappers.userReqToEnt(user, userRequest);
        userRepository.save(user);
    }

    public Optional<UserResponse> getUser(String userId) {
        return userRepository.findById(userId).map(Mappers::getUserResponse);
    }

    public boolean updateUser(String userId, UserRequest userRequest) {

        return userRepository.findById(userId)
                .map(existingUser -> {
                    Mappers.userReqToEnt(existingUser, userRequest);
                    userRepository.save(existingUser);
                    return true;
                })
                .orElse(false);
    }
}
