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
public class shadows {
    
    public static Color shadow_color = new Color(51,51,51);
  
    
    public static void draw_shadow(int x, int y, Graphics2D gg)
    {
        Graphics2D g3 = (Graphics2D) gg;
        g3.setColor(shadow_color);
        g3.fillOval(x, y, 50, 5);
    }
    
}
