package kh.edu.istad.restapim2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private UUID id;
    private String name;
    private String username;
    private String password;
    private boolean isActive;
}