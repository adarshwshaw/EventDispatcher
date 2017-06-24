package com.misclabs.test;

import com.misclabs.core.Window;
import java.awt.Color;

public class Main {
    
    public static void main(String args[]){
        Window w=new Window("Sandbox",640,480);
        w.addLayers(new TestLayer("bottom",Color.BLUE));
        w.addLayers(new TestLayer("top",Color.red));
        w.run();
    }
}
