package com.mchajii.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Central class to process the phone agenda.
 *
 * @author Mohamed Chajii
 */
final class ContactProcessor {

    private static final Logger logger = LoggerFactory.getLogger(ContactProcessor.class);

    private ContactProcessor() {}

    /**
     * Finds the index of the "changing point", which is where we start adding
     * guests from the beginning of the agenda.
     * This implementation assumes that:
     * <ul>
     * <li> The list of guests does not contain null values.
     * <li> The list of guests is sorted with a possible rotation.
     * </ul>
     * Time complexity: O(log n) - Space complexity: O(1).
     *
     * @param guests the list of guests
     * @return the index of the "changing point"
     * @throws IllegalArgumentException in case an invalid list of guests is provided as input
     */
    public static int findIndexChangingPoint(String[] guests) {

        // The guest list that we receive is sorted but rotated. Therefore, we can use a modified version
        // of the binary search algorithm to find the index of the "changing point" element.

        if (guests == null) {
            throw new IllegalArgumentException("'guests' cannot be null");
        }

        if (guests.length == 0) {
            return -1;
        }

        int lowIndex = 0;
        int highIndex = guests.length - 1;
        int middleIndex; // To avoid constant memory allocation inside the loop.

        int changingPointIndex = 0;

        // Using an iterative solution instead of a recursive one allow us to reduce the space complexity.
        while (lowIndex < highIndex) {

            middleIndex = lowIndex + (highIndex - lowIndex) / 2;

            if (middleIndex < highIndex && guests[middleIndex + 1].compareTo(guests[middleIndex]) < 0) {
                changingPointIndex = middleIndex + 1;
                break;
            }

            if (middleIndex > lowIndex && guests[middleIndex].compareTo(guests[middleIndex - 1]) < 0) {
                changingPointIndex = middleIndex;
                break;
            }

            if (guests[highIndex].compareTo(guests[middleIndex]) <= 0) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex - 1;
            }
        }

        logger.info("Changing point index = {} ({}).", changingPointIndex, guests[changingPointIndex]);
        return changingPointIndex;
    }
}
