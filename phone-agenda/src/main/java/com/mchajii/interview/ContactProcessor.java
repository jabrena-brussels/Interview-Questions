package com.mchajii.interview;

/**
 * Central class to process the phone agenda.
 *
 * @author Mohamed Chajii
 */
final class ContactProcessor {

	private ContactProcessor() {}

	/**
	 * Finds the index of the "changing point", which is where we start adding
	 * guests from the beginning of the agenda.
     *
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

        int lowIndex  = 0;
        int highIndex = guests.length - 1;
        int middleIndex; // To avoid constant memory allocation inside the loop.

        while (guests[lowIndex].compareTo(guests[highIndex]) > 0) {

            middleIndex = lowIndex + (highIndex - lowIndex) / 2;

            if (guests[middleIndex].compareTo(guests[highIndex]) > 0) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex;
            }
        }

        return lowIndex;
	}
}
