package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {
    private List<Profile> profileList = new ArrayList<>();

    @Before
    public void setUp() {
        profileList.add(new Profile(new Address("Ufa", "Lenin", 12, 51)));
        profileList.add(new Profile(new Address("Moscow", "Lenin", 12, 51)));
        profileList.add(new Profile(new Address("Perm", "Lenin", 12, 51)));
        profileList.add(new Profile(new Address("Ufa", "Lenin", 12, 51)));
    }

    @Test
    public void collectAddress() {
        List<Address> addressesExpected = new ArrayList<>();
        addressesExpected.add(new Address("Ufa", "Lenin", 12, 51));
        addressesExpected.add(new Address("Moscow", "Lenin", 12, 51));
        addressesExpected.add(new Address("Perm", "Lenin", 12, 51));
        addressesExpected.add(new Address("Ufa", "Lenin", 12, 51));
        List<Address> addressesCollect = Profiles.collect(profileList);
        assertThat(addressesCollect, is(addressesExpected));
    }

    @Test
    public void collectAddressDistinct() {
        List<Address> addressesExpected = new ArrayList<>();
        addressesExpected.add(new Address("Moscow", "Lenin", 12, 51));
        addressesExpected.add(new Address("Perm", "Lenin", 12, 51));
        addressesExpected.add(new Address("Ufa", "Lenin", 12, 51));
        List<Address> addressesCollect = Profiles.collectDistinct(profileList);
        assertThat(addressesCollect, is(addressesExpected));
    }


}