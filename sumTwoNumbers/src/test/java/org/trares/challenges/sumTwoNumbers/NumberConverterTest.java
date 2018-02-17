package org.trares.challenges.sumTwoNumbers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(JUnit4.class)
public class NumberConverterTest {

    @Test
    public void convertSingleDigitNumber(){

        final LinkedList<String> linkedlistResult = NumberConverter.toLinkedList(2);

        final LinkedList<String> linkedListExpected = new LinkedList<>();
        linkedListExpected.addFirst("2");

        assertThat(linkedlistResult, is(linkedListExpected));
    }

    @Test
    public void convertTwoDigitNumber(){

        final LinkedList<String> linkedlistResult = NumberConverter.toLinkedList(23);

        final LinkedList<String> linkedListExpected = new LinkedList<>();
        linkedListExpected.addFirst("2");
        linkedListExpected.addFirst("3");

        assertThat(linkedlistResult, is(linkedListExpected));
    }

}