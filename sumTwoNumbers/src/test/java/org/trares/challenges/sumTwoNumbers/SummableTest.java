package org.trares.challenges.sumTwoNumbers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class SummableTest {

    private LinkedList<String>  convertNumberToLinkedList(int number){

        final String stringNumber = String.valueOf(number);

        LinkedList<String> linkedListResult = new LinkedList<>();
        stringNumber.chars()
            .mapToObj(i -> (char) i)
            .forEach( v -> {
                linkedListResult.addFirst(String.valueOf(v));
        });

        return linkedListResult;
    }

    @Test
    public void sumTwoNumbersWithSuccessTest() {

        final LinkedList<String> linkedlistParam1 = convertNumberToLinkedList(1);
        final LinkedList<String> linkedlistParam2 = convertNumberToLinkedList(1);

        final Summable summable = new SummableImpl();
        final LinkedList linkedListResult = summable.sumTwoNumbers(linkedlistParam1, linkedlistParam2);

        final LinkedList<String> linkedlistExpectedResult = convertNumberToLinkedList(2);

        assertThat(linkedListResult, is(linkedlistExpectedResult));
    }

    @Test
    public void sumTwoNumbersWith2DigitsWithSuccessTest() {

        final LinkedList<String> linkedlistParam1 = convertNumberToLinkedList(10);
        final LinkedList<String> linkedlistParam2 = convertNumberToLinkedList(10);

        final Summable summable = new SummableImpl();
        final LinkedList linkedListResult = summable.sumTwoNumbers(linkedlistParam1, linkedlistParam2);

        final LinkedList<String> linkedlistExpectedResult = convertNumberToLinkedList(20);

        assertThat(linkedListResult, is(linkedlistExpectedResult));
    }

}
