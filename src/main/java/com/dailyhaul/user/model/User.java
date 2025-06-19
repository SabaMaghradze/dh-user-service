package com.dailyhaul.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id; // since default type of id in mongodb is string unlike mysql/postgres

    private String firstName;

    private String lastName;

    @Indexed(unique = true)
    private String email;

    private String phone;

    private Address address;

    private UserRole role = UserRole.CUSTOMER;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
