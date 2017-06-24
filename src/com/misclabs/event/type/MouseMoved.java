package com.misclabs.event.type;

import com.misclabs.event.Event;

public class MouseMoved extends Event{
    protected int x,y;
    protected boolean dragged;

    public MouseMoved(int x,int y,boolean dragged) {
        super(Event.EventType.Mouse_Moved);
        this.x=x;
        this.y=y;
        this.dragged=dragged;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDragged() {
        return dragged;
    }
    
    
}
