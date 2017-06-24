package com.misclabs.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Screen extends Canvas{
    
    private Graphics g;
    private BufferStrategy bs;
    public Screen(int width,int height){
        this.setPreferredSize(new Dimension(width,height));
    }
    
    public void init(){
        this.createBufferStrategy(2);
    }
    
    public Graphics getGraphics(){
        return g;
    }
    
    public void clearBuffer(){
        bs=this.getBufferStrategy();
        g=bs.getDrawGraphics();
        
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    public void flipBuffer(){
        g.dispose();
        bs.show();
    }
}
