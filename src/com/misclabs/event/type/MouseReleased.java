package com.misclabs.event.type;

import com.misclabs.event.Event;

public class MouseReleased extends Event{
    protected int x,y,button;
    public MouseReleased(int x,int y,int button) {
        super(Event.EventType.Mouse_Released);
        this.x=x;
        this.y=y;
        this.button=button;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getButton() {
        return button;
    }
    
}