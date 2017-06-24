/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misclabs.test;

import com.misclabs.core.UILayer;
import com.misclabs.event.Event;
import com.misclabs.event.EventDispatcher;
import com.misclabs.event.type.MouseMoved;
import com.misclabs.event.type.MousePressed;
import com.misclabs.event.type.MouseReleased;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Adarsh Shaw
 */
public class TestLayer extends UILayer{
    private String name;
    private Color color;
    private Rectangle rect;
    
    private int dx,dy;
    private boolean drag = false;
    
    private static Random random=new Random();
    public TestLayer(String name,Color color){
        this.name = name;
        this.color = color;
        
        rect = new Rectangle(random.nextInt(300)+100,random.nextInt(200)+80,80,50);
    }
    
    public void OnEvent(Event e){
        EventDispatcher ed = new EventDispatcher(e);
        ed.dispatch((Event ev) -> onMouseMoved((MouseMoved) e), Event.EventType.Mouse_Moved);
        ed.dispatch((Event ev) -> onMousePressed((MousePressed) e), Event.EventType.Mouse_Pressed);
        ed.dispatch((Event ev) -> onMouseReleased((MouseReleased) e), Event.EventType.Mouse_Released);
    }
    
    public boolean onMouseMoved(MouseMoved mouseMoved){
        int x=mouseMoved.getX();
        int y=mouseMoved.getY();
        
        if(drag){
            rect.x += x - dx;
            rect.y += y - dy;
        }
        
        dx=x;
        dy=y;
        
        return drag;
    }
    
    public boolean onMousePressed(MousePressed mp){
        if(rect.contains(mp.getX(), mp.getY()))
            drag=true;
        return drag;
    }
    
    public boolean onMouseReleased(MouseReleased mr){
        drag=false;
        return drag;
    }
    
    public void onRender(Graphics g){
        g.setColor(color);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }
}