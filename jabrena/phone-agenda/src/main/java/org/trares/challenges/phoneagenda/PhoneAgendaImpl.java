package org.trares.challenges.phoneagenda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhoneAgendaImpl implements PhoneAgenda {

    final String[] partyList;

    public PhoneAgendaImpl(String[] partyList) {

        if(partyList == null) {
            LOGGER.error("Bad partyList provided");
            throw new IllegalArgumentException("Bad partyList provided");
        }

        this.partyList = partyList;
    }

    @Override
    public int getChangingPoint() {

        int index = 0;
        for(int x = 0; x <= partyList.length; x++){

            String current = partyList[x];
            String next = partyList[x+1];

            LOGGER.info("{}", current.compareTo(next));

            if(current.compareTo(next) > 0) {
                index = x+1;
                break;
            }

        }

        return index;
    }
}
