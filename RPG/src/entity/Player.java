package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp; // Reference to GamePanel
    KeyHandler keyH; // Reference to KeyHandler

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp; // Initialize GamePanel reference
        this.keyH = keyH; // Initialize KeyHandler reference
        setDefaultValues(); // Set initial player values
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100; // Initial X position
        y = 100; // Initial Y position
        speed = 4; // Initial speed
        direction = "down";
    }
    // this makes SPRITE IMAGES POSSIBLE
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/img/hero-up.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        // Update direction and movement based on key inputs
        if (keyH.wPressed) {
            direction = "up"; // Set direction to up
            y -= speed; // Move up
        } else if (keyH.sPressed) {
            direction = "down"; // Set direction to down
            y += speed; // Move down
        } else if (keyH.aPressed) {
            direction = "left"; // Set direction to left
            x -= speed; // Move left
        } else if (keyH.dPressed) {
            direction = "right"; // Set direction to right
            x += speed; // Move right
        }
    }

    public void draw(Graphics2D g2) {
   //     g2.setColor(Color.white); // Set color for player
   //     g2.fillRect(x, y, gp.tileSize, gp.tileSize); // Draw player as rectangle
        BufferedImage image = null;

        switch(direction){
            case "up":
                image = up1;
                break;
        }
        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
    }
}
