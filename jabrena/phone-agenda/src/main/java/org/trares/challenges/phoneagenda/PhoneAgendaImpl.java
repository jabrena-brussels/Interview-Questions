package org.trares.challenges.phoneagenda;

public class PhoneAgendaImpl implements PhoneAgenda {

    final String[] partyList;

    public PhoneAgendaImpl(String[] partyList) {
        this.partyList = partyList;
    }

    @Override
    public int getChangingPoint() {
        return 0;
    }
}
