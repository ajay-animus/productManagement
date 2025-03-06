package com.ecommerce.productservice.entity;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Comparable<User> {

    private String name;

    private String address;

    private String phone;

    private Integer id;

    @Override
    public int compareTo(User o) {
        return this.id - o.id;
    }

    public static Comparator<User> newArray = Comparator.comparing(User::getName);

}
