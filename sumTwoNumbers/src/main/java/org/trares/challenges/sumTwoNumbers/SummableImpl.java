package org.trares.challenges.sumTwoNumbers;

import java.util.LinkedList;

public class SummableImpl implements Summable {

    @Override
    public LinkedList<Integer> sumTwoNumbers(final LinkedList<Integer> l1, final LinkedList<Integer> l2) {

        final StringBuilder stringBuilder = new StringBuilder();
        l1.stream().forEach((digit)-> {
            stringBuilder.append(digit);
        });
        final int param1 = Integer.parseInt(stringBuilder.toString());

        final StringBuilder stringBuilder2 = new StringBuilder();
        l2.stream().forEach((digit)-> {
            stringBuilder2.append(digit);
        });
        final int param2 = Integer.parseInt(stringBuilder2.toString());

        final int sum = param1 + param2;

        final LinkedList<Integer> linkedListResult = new LinkedList<>();
        linkedListResult.add(sum);

        return linkedListResult;
    }
}
