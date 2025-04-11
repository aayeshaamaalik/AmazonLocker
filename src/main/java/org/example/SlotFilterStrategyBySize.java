package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class SlotFilterStrategyBySize implements SlotFilterStrategy {
    @Override
    public List<Slot> filterSlots(List<Slot> allSlots, Package pkg) {
        return allSlots.stream()
                .filter(slot -> slot.canAccommodate(pkg))
                .collect(Collectors.toList());
    }
}
