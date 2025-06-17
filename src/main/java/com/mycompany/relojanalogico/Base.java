package com.mycompany.relojanalogico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.Calendar;

public class Base extends JPanel {

    
    Color pinky_ghost = new Color(234, 181, 245);
    Color inky_ghost = new Color(10, 245, 213);
    Color clyde_ghost = new Color(245, 111, 10);
    Color blinky_ghost = new Color(156, 3, 24);
    
    int ghost_size1 = 50;
    int ghost_size2 = 50;
    int ghost_size3 = 50;
    int ghost_size4 = 50;
    int ghost_rectangle1 = 30;
    int ghost_rectangle2 = 30;
    int ghost_rectangle3 = 30;
    int ghost_rectangle4 = 30;


    int dot1_size = 20;
    int dot2_size = 20;
    int dot3_size = 20;
    int dot4_size = 20;
    int dot5_size = 20;
    int dot6_size = 20;
    int dot7_size = 20;
    int dot8_size = 20;
   
    
    Boolean pacman_mode = false;
    int velocity = 10;
    int spinning_velocity = 40;
    int mouth_pacman = 280;
    Boolean mouth_opening = false;
    Boolean bajando = true;
    int y_first = 150;
    int x_first = 290;
    Color dot_color = new Color(236,200,152);
    
    // Reloj
    int centerX = 410; // Coordenada X del centro del reloj
    int centerY = 390; // Coordenada Y del centro del reloj
    int radio = 450;   
    
    @Override 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Color background_color = new Color(0, 11, 40);
        g2.setColor(background_color);
        g2.fillRect(100, 70, 600, 600);
        
        Color ring_color = new Color(255, 222, 0);
        g2.setColor(ring_color);
        g2.setStroke(new BasicStroke(70));
        g2.fillArc(x_first, y_first, 250, 250, spinning_velocity, mouth_pacman);
        
        
        
        shadows.draw_shadow(165, 80, g2); 
        shadows.draw_shadow(45, 230, g2);  
        shadows.draw_shadow(595, 80, g2);  
        shadows.draw_shadow(705, 230, g2);  
        shadows.draw_shadow(595, 700, g2);  
        shadows.draw_shadow(705, 580, g2);  
        shadows.draw_shadow(165, 700, g2);  
        shadows.draw_shadow(45, 580, g2);
        
        
        g2.setColor(dot_color);
        g2.fillOval(180, 50, dot1_size, dot1_size);
        g2.fillOval(60, 200, dot2_size, dot2_size);
        g2.fillOval(610, 50, dot3_size, dot3_size);
        g2.fillOval(720, 200, dot4_size, dot4_size);
        g2.fillOval(610, 670, dot5_size, dot5_size);
        g2.fillOval(720, 545, dot6_size, dot6_size);
        g2.fillOval(180, 670, dot7_size, dot7_size);
        g2.fillOval(60, 545, dot8_size, dot8_size);
        
      
        
        g2.setColor(pinky_ghost);
        g2.fillOval(385, 20, ghost_size1, ghost_size1);
        g2.fillRect(385, 48, ghost_size1, ghost_rectangle1);
        eyes.draw_eyes(387, 30, g2);
        eyes.draw_pupils(392, 35, g2);
        shadows.draw_shadow(384, 100, g2);  
        
 
        
        g2.setColor(inky_ghost);
        g2.fillOval(20, 350, ghost_size2, ghost_size2);
        g2.fillRect(20, 377, ghost_size2, ghost_rectangle2);
        eyes.draw_eyes(23, 360, g2);
        eyes.draw_pupils(28, 365, g2);
        shadows.draw_shadow(20, 430, g2);  
        
       
        
        g2.setColor(clyde_ghost);
        g2.fillOval(730, 350, ghost_size3, ghost_size3);
        g2.fillRect(730, 377, ghost_size3, ghost_rectangle3);
        eyes.draw_eyes(732, 360, g2);
        eyes.draw_pupils(737, 365, g2);
        shadows.draw_shadow(730, 430, g2);  
        
     
        
        g2.setColor(blinky_ghost);
        g2.fillOval(385, 690, ghost_size4, ghost_size4);
        g2.fillRect(385, 715, ghost_size4, ghost_rectangle4);
        eyes.draw_eyes(387, 700, g2);
        eyes.draw_pupils(392, 704, g2);
        shadows.draw_shadow(384, 760, g2);  
     
        
        drawClock(g2);
        g2.setColor(new Color(74,0,0));
        g2.fillOval(370, 350, 80, 80);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawClock(Graphics2D g2) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int millisecond = cal.get(Calendar.MILLISECOND);  
   
        double hourAngle = Math.toRadians(((hour % 12) + minute / 60.0) * 30 - 90);  // la explicacion de estas formulas seria, el residuo de la hora del dia mas los minutos divididos entre 60 porque existen 60 minutos en el reloj, por los 30 grados de cada hora, menos 90, para que inicie en el punto inicial del reloj
        double minuteAngle = Math.toRadians((minute + second / 60.0) * 6 - 90);  
        double secondAngle = Math.toRadians((second + millisecond / 1000.0) * 6 - 90);  

        g2.setStroke(new BasicStroke(30));
        g2.setColor(Color.black);
        g2.drawLine(centerX, centerY, 
                    (int) (centerX + Math.cos(hourAngle) * radio * 0.5),
                    (int) (centerY + Math.sin(hourAngle) * radio * 0.5));

        g2.setStroke(new BasicStroke(20));
        g2.drawLine(centerX, centerY, 
                    (int) (centerX + Math.cos(minuteAngle) * radio * 0.8),
                    (int) (centerY + Math.sin(minuteAngle) * radio * 0.8));

        g2.setStroke(new BasicStroke(10));
        g2.setColor(new Color(146,0,44));
        g2.drawLine(centerX, centerY, 
                    (int) (centerX + Math.cos(secondAngle) * radio * 0.9),
                    (int) (centerY + Math.sin(secondAngle) * radio * 0.9));
    }

    public void flying_animation() {
       if(pacman_mode == false)
       {
        if (bajando) {
            y_first += velocity;
        }
        if (y_first > 400) {
            bajando = false;
        }
        if (!bajando) {
            y_first -= velocity;
        }
        if (y_first == 100) {
            bajando = true;
        }
        
       }
      repaint();  
        
    }

    public void mouth_open_and_closing() {
       if(pacman_mode == false)
       {
        spinning_velocity += 5;
       }
        if (mouth_opening == false) {
            mouth_pacman += 10;
        } else {
            mouth_pacman -= 10;
        }
        if (mouth_pacman >= 380) {
            mouth_opening = true;
        }
        if (mouth_pacman <= 280) {
            mouth_opening = false;
        }
        mouth_pacman = Math.max(280, Math.min(mouth_pacman, 380));
      repaint(); 
        
    }
    
    public void enter_pacman_mode()
    {
        pacman_mode = true;
        spinning_velocity = 40;
        mouth_pacman = 280;
        x_first = 290;
        y_first= 150;
    }
    
    
}