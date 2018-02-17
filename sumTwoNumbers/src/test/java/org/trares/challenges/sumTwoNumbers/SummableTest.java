package org.trares.challenges.sumTwoNumbers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class SummableTest {

    @Test
    public void sumTwoNumbersWithSuccessTest() {

        final LinkedList<String> linkedlistParam1 = NumberConverter.toLinkedList(1);
        final LinkedList<String> linkedlistParam2 = NumberConverter.toLinkedList(1);

        final Summable summable = new SummableImpl();
        final LinkedList linkedListResult = summable.sumTwoNumbers(linkedlistParam1, linkedlistParam2);

        final LinkedList<String> linkedlistExpectedResult = NumberConverter.toLinkedList(2);

        assertThat(linkedListResult, is(linkedlistExpectedResult));
    }

    @Test
    public void sumTwoNumbersWith2DigitsWithSuccessTest() {

        final LinkedList<String> linkedlistParam1 = NumberConverter.toLinkedList(10);
        final LinkedList<String> linkedlistParam2 = NumberConverter.toLinkedList(10);

        final Summable summable = new SummableImpl();
        final LinkedList linkedListResult = summable.sumTwoNumbers(linkedlistParam1, linkedlistParam2);

        final LinkedList<String> linkedlistExpectedResult = NumberConverter.toLinkedList(20);

        assertThat(linkedListResult, is(linkedlistExpectedResult));
    }

    @Test
    public void sumWithNullParameterTest(){

        final LinkedList<String> linkedlistParam1 = new LinkedList<>();
        final LinkedList<String> linkedlistParam2 = NumberConverter.toLinkedList(10);

        final Summable summable = new SummableImpl();
        summable.sumTwoNumbers(linkedlistParam1, linkedlistParam2);
    }

}
