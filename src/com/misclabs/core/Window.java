package com.misclabs.core;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Window extends JFrame{
    
    private List<UILayer> layers = new ArrayList<>();
    public Window(String name,int width,int height){
        this.setTitle(name);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    
}
