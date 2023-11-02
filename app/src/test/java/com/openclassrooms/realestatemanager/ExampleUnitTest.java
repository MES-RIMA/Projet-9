package com.openclassrooms.realestatemanager;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void convertDollarToEuro() {
        // 100$ =>81€
        final int dollars = 100;
        final int euros = Utils.convertDollarToEuro(dollars);
        assertEquals(euros, 81);
    }
    @Test
    public void convertEuroToDollar() {
        // 81€ => 100$
        final int euros = 81;
        final int dollars = Utils.convertEuroToDollar(euros);
        assertEquals(dollars, 100);
    }
}