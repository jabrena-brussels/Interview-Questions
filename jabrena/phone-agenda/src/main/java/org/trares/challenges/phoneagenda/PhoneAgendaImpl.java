package org.trares.challenges.phoneagenda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhoneAgendaImpl implements PhoneAgenda {

    final String[] partyList;

    public PhoneAgendaImpl(String[] partyList) {

        if((partyList == null) || (partyList.length == 0)) {
            LOGGER.error("Bad partyList provided");
            throw new IllegalArgumentException("Bad partyList provided");
        }

        this.partyList = partyList;
    }

    @Override
    public int getChangingPoint() {

        int index = 0;

        index = linealSearch();

        return index;
    }

    private int linealSearch() {

        int index = 0;

        if(partyList.length == 1){
            return index;
        }

        for(int x = 0; x < partyList.length -1; x++){

            String current = partyList[x];
            String next = partyList[x + 1];

            LOGGER.trace("Comparison result: {}", current.compareTo(next));

            if(current.compareTo(next) > 0) {
                index = x + 1;
                break;
            }
        }

        return index;
    }

    //Development in progress
    //Original Idea: https://github.com/eugenp/tutorials/blob/master/algorithms/src/main/java/com/baeldung/algorithms/binarysearch/BinarySearch.java
    private int iterativeBinarySearch() {

        int index = Integer.MAX_VALUE;

        int low = 0;
        int high = partyList.length - 1;
        int mid;

        while (low <= high) {

            mid = (low + high) / 2;

            String current = partyList[mid];
            String next = partyList[mid + 1];

            /*
            Criterias to move

            if (partyList[mid] < key) {
                low = mid + 1;
            } else if (partyList[mid] > key) {
                high = mid - 1;
            } else if (partyList[mid] == key) {
                index = mid;
                break;
            }
            */
        }
        return index;
    }

}