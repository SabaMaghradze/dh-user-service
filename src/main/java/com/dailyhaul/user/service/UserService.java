package com.dailyhaul.user.service;

import com.dailyhaul.user.dto.UserRequest;
import com.dailyhaul.user.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponse> getAllUsers();

    void addUser(UserRequest userRequest);

    Optional<UserResponse> getUser(String userId);

    boolean updateUser(String userId, UserRequest userRequest);
}
