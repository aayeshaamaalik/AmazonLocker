package org.example;

import java.util.List;

public interface SlotAssignmentStrategy {
    Slot pickSlot(List<Slot> filteredSlots);
}
