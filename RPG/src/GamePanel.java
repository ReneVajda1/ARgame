import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3; // Scale factor for larger tiles
    final int tileSize = originalTileSize * scale; // 48x48 tile size
    final int maxScreenCol = 16; // Number of columns
    final int maxScreenRow = 12; // Number of rows
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    KeyHandler keyH = new KeyHandler(); // Handles key inputs (added)
    Thread gameThread; // Game loop thread

    // Player default position and speed
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Set panel size
        this.setBackground(Color.black); // Background color
        this.setDoubleBuffered(true); // Improve rendering performance
        this.addKeyListener(keyH); // Add KeyHandler to listen for key inputs (added)
        this.setFocusable(true); // Ensure the panel can receive key inputs (added)
    }

    public void startGameThread() {
        gameThread = new Thread(this); // Create the game loop thread
        gameThread.start(); // Start the thread
    }

    @Override
    public void run() {
        while (gameThread != null) { // Keep running while the thread exists
            update(); // Update game logic
            repaint(); // Redraw the screen
            try {
                Thread.sleep(16); // Pause for ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // Update player position based on key input (added)
        if (keyH.wPressed) playerY -= playerSpeed; // Move up
        if (keyH.sPressed) playerY += playerSpeed; // Move down
        if (keyH.aPressed) playerX -= playerSpeed; // Move left
        if (keyH.dPressed) playerX += playerSpeed; // Move right
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw player (added)
        g2.setColor(Color.white); // Set color for the player
        g2.fillRect(playerX, playerY, tileSize, tileSize); // Draw player rectangle
        g2.dispose(); // Release graphics resources
    }
}
