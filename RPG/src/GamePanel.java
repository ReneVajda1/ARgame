
import javax.swing.JPanel;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable {

    final int originalTilesize = 16; // 16x16
    final int scale = 3;

    final int tileSize = originalTilesize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //player default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }
public void startGameThread(){
        gameThread = new Thread(this::startGameThread);
        gameThread.start();
}
    @Override
    public void run(){

        while(gameThread != null) {

            update();

            repaint();
        }

    }
    public void update() {

        if(keyH.upPressed == true) {
            playerY -= playerSpeed;

        } else if (keyH.downPresed == true) {
            playerY += playerSpeed;
            
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
            
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }

    }

    public void paintComponent (Graphics g) { //creating a white rectangle/object and his coordinations

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();


    }

}
