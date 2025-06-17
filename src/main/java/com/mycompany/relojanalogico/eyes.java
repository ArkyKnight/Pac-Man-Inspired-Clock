/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.relojanalogico;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author arky
 */
public class eyes{
        public static Color eyes_color = new Color(255,255,255);
        public static Color pupils_color = new Color(22,22,229);
        

        public static void draw_eyes(int x, int y, Graphics2D gg)
        {
         
          Graphics2D g2 = (Graphics2D) gg;
          g2.setColor(eyes_color);
          g2.fillOval(x, y, 20,20);
          g2.fillOval(x+25,y,20,20);
        }
        
        public static void draw_pupils(int x, int y, Graphics2D gg)
        {
          Graphics2D g2 = (Graphics2D) gg;
          g2.setColor(pupils_color);
          g2.fillOval(x, y, 10,10);
          g2.fillOval(x+25,y,10,10);
        }
           
    }