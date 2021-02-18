package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }


    public static List<Address> collectDistinct(List<Profile> profiles) {
        List<Address> addressList = new ArrayList<>() {

        };
        profiles.stream()
                .distinct()
                .map(profile -> profile.address)
                .collect(Collectors.toList());
        return addressList;
    }


    public Address getAddress() {
        return address;
    }
}
