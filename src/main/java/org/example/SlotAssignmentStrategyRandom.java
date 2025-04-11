package org.example;

import java.util.List;
import java.util.Random;

public class SlotAssignmentStrategyRandom implements SlotAssignmentStrategy {
    private final Random random = new Random();

    @Override
    public Slot pickSlot(List<Slot> filteredSlots) {
        if (filteredSlots == null || filteredSlots.isEmpty()) {
            throw new IllegalArgumentException("No slots available to assign.");
        }
        int index = random.nextInt(filteredSlots.size());
        return filteredSlots.get(index);
    }
}


/*
Future scope:

        SlotAssignmentStrategyLeastUsed

        SlotAssignmentStrategyNearestToUser

        SlotFilterStrategyByLocation*/
