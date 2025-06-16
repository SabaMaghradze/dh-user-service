package com.dailyhaul.user.utils;

import com.dailyhaul.user.dto.AddressDTO;
import com.dailyhaul.user.dto.UserRequest;
import com.dailyhaul.user.dto.UserResponse;
import com.dailyhaul.user.model.Address;
import com.dailyhaul.user.model.User;

public class Mappers {

    public static UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getRole());

        if (user.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO(user.getAddress().getStreet(),
                    user.getAddress().getCity(),
                    user.getAddress().getState(),
                    user.getAddress().getCountry(),
                    user.getAddress().getZipcode());

            userResponse.setAddress(addressDTO);
        }

        return userResponse;
    }

    public static User userReqToEnt(User user, UserRequest userRequest) {

        user.setFirstName(userRequest.getFirstName() != null ? userRequest.getFirstName() : user.getFirstName());
        user.setLastName(userRequest.getLastName() != null ? userRequest.getLastName() : user.getLastName());
        user.setEmail(userRequest.getEmail() != null ? userRequest.getEmail() : user.getEmail());
        user.setPhone(userRequest.getPhone() != null ? userRequest.getPhone() : user.getPhone());

        if (userRequest.getAddress() != null) {
            Address address = new Address(userRequest.getAddress().getStreet(),
                    userRequest.getAddress().getCity(),
                    userRequest.getAddress().getState(),
                    userRequest.getAddress().getCountry(),
                    userRequest.getAddress().getZipcode());

            user.setAddress(address);
        }

        return user;
    }
}
