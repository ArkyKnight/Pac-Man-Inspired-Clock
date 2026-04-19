# Pac-Clock
## Introduction:
Within this project, you will find a functional atomic clock made in Java, with the theme of the video game:
<img width="768" height="432" alt="image" src="https://github.com/user-attachments/assets/572cf38f-919e-4e22-8772-d0f299e414bd" />

Using the ```Java Awt``` and ```Java Swing libraries```, it contains animations for greater appeal, in this case using Threads,
and also accepts Inputs.

## General operation:
When opening the application, the user will see an atomic clock. The difference between normal clocks and atomic clocks is that atomic clocks measure time more accurately thanks to the physical stability of the atom, which oscillates at a constant frequency of: ```9,192,631,770 oscillations per second``` . Because of this, the clock has a noticeable fluid effect compared to normal clocks.

If the user clicks on PAC-MAN (The character of the center), it will detach from his origin and the ghost all around will turn blue, also the program will begin to receive input. If the user presses the keys WASD, PAC-MAN will begin to move in the corresponding directions W=UP,S=DOWN,A=LEFT and lastly D=RIGHT, if the user chooses to move PAC-MAN near a ghost, the ghost will be eaten and dissapear letting only his eyes in his last position.

![ezgif-371228fc41be998c](https://github.com/user-attachments/assets/b083276b-6bcb-4121-809d-7471fa70bef4)

## Technologies used:
- Main language: Java.
- Use of Java Swing and AWT ```javax.swing.JFrame```,```javax.swing.Timer```,```java.awt.Color``` and ```java.awt.event.*```.
- Use of event listeners, ```MouseListener```, ```KeyListener``` and ```ActionListener```.
- Real-time animations using timers, ```javax.swing.Timer```.
- Use of Java Audio API, ```javax.sound.sampled.AudioSystem```, ```javax.sound.sampled ```.  ```AudioSystem ```,  ```javax.sound.sampled.AudioSystem ```.
- Handling .wav audio files, java.io.File, and java.io.IOException.
- Use of object-oriented programming in classes such as relojanalogico and base.



