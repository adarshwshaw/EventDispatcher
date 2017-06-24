package com.misclabs.event;

@FunctionalInterface
public interface EventHandler {
    public boolean onEvent(Event e);
}
