package com.misclabs.event;

public class Event {
    
    public enum EventType{
        Mouse_Moved,
        Mouse_Pressed,
        Mouse_Released
    }
    protected EventType eventType;
    protected boolean isHandled;
    protected Event(EventType type){
        eventType=type;
    }
    
    public EventType getEventType(){
        return eventType;
    }

    public boolean isIsHandled() {
        return isHandled;
    }
    
}
