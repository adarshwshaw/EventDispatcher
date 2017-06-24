package com.misclabs.event;

public class EventDispatcher {
    private Event event;
    
    public EventDispatcher(Event e){
        this.event=e;
    }
    
    public void dispatch(EventHandler handler,Event.EventType type){
        if(event.isHandled){//return;
        }
        else if(type == event.eventType)
            event.isHandled=handler.onEvent(event);
    }
}
