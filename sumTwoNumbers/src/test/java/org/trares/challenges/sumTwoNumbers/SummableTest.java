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

        final LinkedList<Integer> linkedlistParam1 = new LinkedList<Integer>();
        linkedlistParam1.add(1);

        final LinkedList<Integer> linkedlistParam2 = new LinkedList<Integer>();
        linkedlistParam2.add(1);

        final Summable summable = new SummableImpl();
        final LinkedList linkedListResult = summable.sumTwoNumbers(linkedlistParam1, linkedlistParam2);

        final LinkedList<Integer> linkedlistExpectedResult = new LinkedList<Integer>();
        linkedlistExpectedResult.add(2);

        assertThat(linkedlistExpectedResult, is(linkedListResult));
    }

}
