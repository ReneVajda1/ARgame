package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity {
    GamePanel gp; // Reference to GamePanel
    KeyHandler keyH; // Reference to KeyHandler

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp; // Initialize GamePanel reference
        this.keyH = keyH; // Initialize KeyHandler reference
        setDefaultValues(); // Set initial player values
    }

    public void setDefaultValues() {
        x = 100; // Initial X position
        y = 100; // Initial Y position
        speed = 4; // Initial speed
    }

    public void update() {
        if (keyH.wPressed) y -= speed; // Move up
        if (keyH.sPressed) y += speed; // Move down
        if (keyH.aPressed) x -= speed; // Move left
        if (keyH.dPressed) x += speed; // Move right
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white); // Set color for player
        g2.fillRect(x, y, gp.tileSize, gp.tileSize); // Draw player as rectangle
    }
}
