package org.trares.challenges.sumTwoNumbers;

import java.util.LinkedList;

public class NumberConverter {

    public static LinkedList<String> toLinkedList(int number){

        final String stringNumber = String.valueOf(number);

        LinkedList<String> linkedListResult = new LinkedList<>();
        stringNumber.chars()
                .mapToObj(i -> (char) i)
                .forEach( v -> {
                    linkedListResult.addFirst(String.valueOf(v));
                });

        return linkedListResult;
    }

}
