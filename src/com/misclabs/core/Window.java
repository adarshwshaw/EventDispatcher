package com.misclabs.core;


import com.misclabs.event.Event;
import com.misclabs.event.type.MouseMoved;
import com.misclabs.event.type.MousePressed;
import com.misclabs.event.type.MouseReleased;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Window extends JFrame{
    
    private final List<UILayer> layers;
    private final Screen screen;
    public Window(String name,int width,int height){
        layers = new ArrayList<>();
        screen=new Screen(width,height);
        this.setTitle(name);
        this.add(screen);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        screen.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                MouseReleased mr=new MouseReleased(e.getX(), e.getY(), e.getButton());
                onEvent(mr);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                MousePressed mp=new MousePressed(e.getX(), e.getY(), e.getButton());
                onEvent(mp);
            }
            
        });
        
        screen.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                MouseMoved mm=new MouseMoved(e.getX(), e.getY(), true);
                onEvent(mm);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                MouseMoved mm=new MouseMoved(e.getX(), e.getY(), false);
                onEvent(mm);
            }
        });
        setVisible(true);
        
        screen.init();
    }
    
    public void addLayers(UILayer ui){
        layers.add(ui);
    }
    
    public void run(){
        screen.clearBuffer();
        onRender(screen.getGraphics());
        screen.flipBuffer();
        
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        SwingUtilities.invokeLater(() -> run());
    }
    
    private void onEvent(Event e){
        System.out.println(e);
        for(int i=layers.size()-1;i>=0;i--)
            layers.get(i).OnEvent(e);
    }
    
    private void onRender(Graphics g){
        for(int i=0;i<layers.size();i++)
            layers.get(i).onRender(g);
    }
}