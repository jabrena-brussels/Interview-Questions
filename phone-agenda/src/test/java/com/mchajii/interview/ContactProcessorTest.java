package com.mchajii.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class ContactProcessorTest {

    private static final String[] guests = {"Adam", "Alesia", "Bridget", "Celine", "Charlie", "Diane", "Fabio",
            "George", "Gregory", "Hugo", "James", "Julia", "Lara", "Noah", "Pamela", "Paul", "Pauline", "Salima", "Sandra", "Tudor"};
    
    @Test
    void shouldThrowExceptionWhenGuestArrayIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ContactProcessor.findIndexChangingPoint(null));
    }

    @Test
    void shouldReturnNegativeValueForEmptyGuestArray() {
        Assertions.assertEquals(ContactProcessor.findIndexChangingPoint(new String[]{}), -1);
    }

    @Test
    void shouldReturnZeroForSingleGuest() {
        Assertions.assertEquals(ContactProcessor.findIndexChangingPoint(new String[]{"Adam"}), 0);
    }

    @Test
    void checkIndexForGuestsWithAllSameName() {
        Assertions.assertEquals(ContactProcessor.findIndexChangingPoint(new String[]{"Adam", "Adam", "Adam"}), 0);
    }

    @Test
    void checkIndexForGuestsWithDuplicates() {
        String[] guestsWithDuplicates = new String[]{"Bridget", "Bridget", "Bridget", "Bridget", "Bridget",
                "Bridget", "Bridget", "Bridget", "Adam", "Alesia",  "Alesia", "Bridget"};

        Assertions.assertEquals(ContactProcessor.findIndexChangingPoint(guestsWithDuplicates), 8);
    }


    @Test
    void shouldReturnCorrectChangingPointIndex() {
        for (int i = 0; i < guests.length; i++) {
            String[] guestsCopy = Arrays.stream(guests).toArray(String[]::new);
            Collections.rotate(Arrays.asList(guestsCopy), i);
            Assertions.assertEquals(ContactProcessor.findIndexChangingPoint(guestsCopy), i);
        }
    }
}
