package com.kishore.lombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
}