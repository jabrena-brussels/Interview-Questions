package com.mchajii.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactProcessorTest {

    // TODO: Add tests

    @Test
    void shouldThrowExceptionWhenGuestsIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ContactProcessor.findIndexChangingPoint(null));
    }
}
