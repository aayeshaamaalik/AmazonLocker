package org.example;

import java.util.List;

public interface SlotFilterStrategy {
    List<Slot> filterSlots(List<Slot> allSlots, Package pkg);
}

