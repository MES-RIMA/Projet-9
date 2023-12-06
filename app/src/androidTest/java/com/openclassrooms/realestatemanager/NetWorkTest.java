package com.openclassrooms.realestatemanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.realestatemanager.utils.Utils;

@RunWith(JUnit4.class)
public class NetWorkTest {
    @Test
    public void isInternetAvailable_test() {
        assertFalse(Utils.isInternetAvailable());
    }

}