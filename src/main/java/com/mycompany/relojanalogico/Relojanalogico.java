package com.mycompany.relojanalogico;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Relojanalogico extends JFrame implements MouseListener,KeyListener{
    
    Base canvas = new Base();
    
    Color scared_ghost = new Color(0,23,138);
    
    Boolean eat_pinky = false;
    Boolean eat_inky = false;
    Boolean eat_clyde = false;
    Boolean eat_blinky = false;
    
    Boolean waka_played_dot1 = false;
    Boolean waka_played_dot2 = false;
    Boolean waka_played_dot3 = false;
    Boolean waka_played_dot4 = false;
    Boolean waka_played_dot5 = false;
    Boolean waka_played_dot6 = false;
    Boolean waka_played_dot7 = false;
    Boolean waka_played_dot8 = false;

    
    private Clip audioClip;

    public Relojanalogico() {
        super("Reloj Analogico");
     
        Color background_color = new Color(0,0,51);
        canvas.setBackground(background_color);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(canvas);
        addMouseListener(this);
        addKeyListener(this);

       
        playMusic("src/main/java/com/mycompany/relojanalogico/musica/pacman.wav");


        Timer on_the_air_animation = new Timer(17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.flying_animation();
                canvas.mouth_open_and_closing();
                detect_dot();
                eat_ghost();
                System.out.println(canvas.x_first);
                System.out.println(canvas.y_first);
            }
        });
        
        on_the_air_animation.start();
    }


    private void playMusic(String filePath) {
        try {
            File audioFile = new File(filePath); 
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY); 
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

 public void playSound(String soundName)
 {
   try 
   {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
    Clip clip = AudioSystem.getClip();
    clip.open(audioInputStream);
    clip.start();
   }
   catch(Exception ex)
   {
     System.out.println("Error with playing sound.");
     ex.printStackTrace( );
   }
 }    
  
    private void stopMusic() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
        }
    }

    public static void main(String[] args) {
        
        new Relojanalogico();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         System.out.println("PACMAN MODE");
         canvas.enter_pacman_mode();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int KeyCode = e.getKeyCode();
        if(canvas.pacman_mode == true)
        {
         canvas.blinky_ghost = scared_ghost;
         canvas.pinky_ghost = scared_ghost;
         canvas.inky_ghost = scared_ghost;
         canvas.clyde_ghost = scared_ghost;
         
      
     
         
         if(KeyCode == KeyEvent.VK_W)
         {
             canvas.y_first -= 20;
             canvas.spinning_velocity =  100;
             
         }
         if(KeyCode == KeyEvent.VK_S)
         {
             canvas.y_first += 20;
             canvas.spinning_velocity =  300;
             
         }
         if(KeyCode == KeyEvent.VK_A)
         {
             canvas.x_first -= 20;
             canvas.spinning_velocity =  200;
         }
         
         if(KeyCode == KeyEvent.VK_D)
         {
             canvas.x_first += 20;
             canvas.spinning_velocity =  40;
         }    
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void detect_dot()
    {
    
        
        if(canvas.x_first == 170 && canvas.y_first == -70)
        {
            canvas.dot1_size = 0;
        }
        
        if(canvas.x_first == 30 && canvas.y_first == 110)
        {
            canvas.dot2_size = 0;
        }
        if(canvas.x_first == 410 && canvas.y_first == -70)
        {
            canvas.dot3_size = 0;
        }
        if(canvas.x_first == 510 && canvas.y_first == 110)
        {
            canvas.dot4_size = 0;
        }
        if(canvas.x_first == 390 && canvas.y_first == 550)
        {
            canvas.dot5_size = 0;
        }
        if(canvas.x_first == 510 && canvas.y_first == 450)
        {
            canvas.dot6_size = 0;
        }
        if(canvas.x_first == 150 && canvas.y_first == 550)
        {
            canvas.dot7_size = 0;
        }
        if(canvas.x_first == 50 && canvas.y_first == 450)
        {
            canvas.dot8_size = 0;
        }
    
        if (canvas.dot1_size == 0 && !waka_played_dot1) {
        playSound("src/main/java/com/mycompany/relojanalogico/musica/waka.wav");
        waka_played_dot1 = true; 
        }
        if (canvas.dot2_size == 0 && !waka_played_dot2) {
        playSound("src/main/java/com/mycompany/relojanalogico/musica/waka.wav");
        waka_played_dot2 = true; 
        }
        if (canvas.dot3_size == 0 && !waka_played_dot3) {
        playSound("src/main/java/com/mycompany/relojanalogico/musica/waka.wav");
        waka_played_dot3 = true; 
        }
        if (canvas.dot4_size == 0 && !waka_played_dot4) {
        playSound("src/main/java/com/mycompany/relojanalogico/musica/waka.wav");
        waka_played_dot4  = true; 
        }
        if (canvas.dot5_size == 0 && !waka_played_dot5) {
        playSound("src/main/java/com/mycompany/relojanalogico/musica/waka.wav");
        waka_played_dot5  = true; 
        }
        if (canvas.dot6_size == 0 && !waka_played_dot6) {
        playSound("src/main/java/com/mycompany/relojanalogico/musica/waka.wav");
        waka_played_dot6 = true; 
        }
        if (canvas.dot7_size == 0 && !waka_played_dot7 ) {
        playSound("src/main/java/com/mycompany/relojanalogico/musica/waka.wav");
        waka_played_dot7 = true; 
        }
        if (canvas.dot8_size == 0 && !waka_played_dot8) {
        playSound("src/main/java/com/mycompany/relojanalogico/musica/waka.wav");
        waka_played_dot8 = true; 
        }
       
        
       
    }
    
    public void eat_ghost() 
    {
        if(canvas.x_first == 290 && canvas.y_first == 10)
        {
          canvas.ghost_rectangle1 = 0;
          canvas.ghost_size1 = 0;
        }
        if(canvas.x_first == 30 && canvas.y_first == 290)
        {
          canvas.ghost_rectangle2 = 0;
          canvas.ghost_size2 = 0;
        }
        if(canvas.x_first == 530 && canvas.y_first == 290)
        {
          canvas.ghost_rectangle3 = 0;
          canvas.ghost_size3 = 0;
        }
        if(canvas.x_first == 490 && canvas.y_first == 610)
        {
          canvas.ghost_rectangle4 = 0;
          canvas.ghost_size4 = 0;
        }
    
    if(canvas.ghost_rectangle1 == 0 && canvas.ghost_size1 == 0 && !eat_pinky)
    {
      playSound("src/main/java/com/mycompany/relojanalogico/musica/ghost.wav");
      eat_pinky = true;
    }
    if(canvas.ghost_rectangle2 == 0 && canvas.ghost_size2 == 0 && !eat_inky)
    {
      playSound("src/main/java/com/mycompany/relojanalogico/musica/ghost.wav");
      eat_inky = true;
    }
    if(canvas.ghost_rectangle3 == 0 && canvas.ghost_size3 == 0 && !eat_clyde)
    {
      playSound("src/main/java/com/mycompany/relojanalogico/musica/ghost.wav");
      eat_clyde = true;
    }
    if(canvas.ghost_rectangle4 == 0 && canvas.ghost_size4 == 0 && !eat_blinky)
    {
      playSound("src/main/java/com/mycompany/relojanalogico/musica/ghost.wav");
      eat_blinky = true;
    }
   
    
    }

}
