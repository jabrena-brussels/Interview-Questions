package org.trares.challenges.sumTwoNumbers;

import java.util.LinkedList;

public class SummableImpl implements Summable {

    private int getParam(final LinkedList<Integer> param) {

        final StringBuilder stringBuilder = new StringBuilder();
        param.stream().forEach((digit)-> {
            stringBuilder.append(digit);
        });
        return Integer.parseInt(stringBuilder.toString());
    }

    private LinkedList<Integer> convertFromLinkedListToInt(final int result){

        final LinkedList<Integer> linkedListResult = new LinkedList<>();
        linkedListResult.add(result);

        return linkedListResult;
    }

    @Override
    public LinkedList<Integer> sumTwoNumbers(final LinkedList<Integer> l1, final LinkedList<Integer> l2) {

        final int param1 = getParam(l1);
        final int param2 = getParam(l2);
        final int sum = param1 + param2;

        return convertFromLinkedListToInt(sum);
    }
}
