package org.trares.challenges.sumTwoNumbers;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class SummableImpl implements Summable {

    private int getParam(final LinkedList<String> param) {

        if(param.size() == 0) {
            throw new IllegalArgumentException("Bad List provided");
        }

        final StringBuilder stringBuilder = new StringBuilder();
        param.stream()
            .collect(Collectors.toCollection(LinkedList::new))
            .descendingIterator()
            .forEachRemaining( s -> {
                stringBuilder.append(s);
        });
        return Integer.parseInt(stringBuilder.toString());
    }

    @Override
    public LinkedList<String> sumTwoNumbers(final LinkedList<String> l1, final LinkedList<String> l2) {

        final int param1 = getParam(l1);
        final int param2 = getParam(l2);
        final int sum = param1 + param2;

        return NumberConverter.toLinkedList(sum);
    }
}
