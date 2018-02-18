package org.trares.challenges.sumTwoNumbers;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class SummableImpl implements Summable {

    private static final String DIGIT_REGEX = "[0-9]{1}";
    private static final Pattern DIGIT_PATTERN = Pattern.compile(DIGIT_REGEX);

    public boolean isNumerical(final String digit){
        return DIGIT_PATTERN.matcher(digit).matches();
    }

    private int getParam(final LinkedList<String> param) {

        if(param.size() == 0) {
            LOGGER.error("Bad List provided");
            throw new IllegalArgumentException("Bad List provided");
        }

        final StringBuilder stringBuilder = new StringBuilder();
        param.stream()
            .collect(Collectors.toCollection(LinkedList::new))
            .descendingIterator()
            .forEachRemaining( s -> {
                if(isNumerical(s)) {
                    stringBuilder.append(s);
                }else {
                    LOGGER.error("Bad digit: {}", s);
                    throw new IllegalArgumentException("Bad digit: " + s);
                }
        });
        return Integer.parseInt(stringBuilder.toString());
    }

    @Override
    public LinkedList<String> sumTwoNumbers(final LinkedList<String> l1, final LinkedList<String> l2) {

        final int param1 = getParam(l1);
        final int param2 = getParam(l2);
        final int sum = param1 + param2;

        if(Integer.toUnsignedLong(sum) >= Integer.MAX_VALUE) {
            throw new RuntimeException("Check numbers to Sum");
        }

        return NumberConverter.toLinkedList(sum);
    }
}
