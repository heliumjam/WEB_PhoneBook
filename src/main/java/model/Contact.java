package model;

import lombok.*;


@Setter
@Getter
@Builder
@ToString

public class Contact {
    String name;
    String lastName;
    String phone;
    String email;
    String address;
    String description;


}
