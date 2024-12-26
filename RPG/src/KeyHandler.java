import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    // Booleans to track key states (added)
    public boolean wPressed, aPressed, sPressed, dPressed;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // Get the keycode of the pressed key

        // Set boolean flags based on pressed keys (added)
        if (code == KeyEvent.VK_W) wPressed = true; // W key
        if (code == KeyEvent.VK_S) sPressed = true; // S key
        if (code == KeyEvent.VK_A) aPressed = true; // A key
        if (code == KeyEvent.VK_D) dPressed = true; // D key
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); // Get the keycode of the released key

        // Reset boolean flags based on released keys (added)
        if (code == KeyEvent.VK_W) wPressed = false; // W key
        if (code == KeyEvent.VK_S) sPressed = false; // S key
        if (code == KeyEvent.VK_A) aPressed = false; // A key
        if (code == KeyEvent.VK_D) dPressed = false; // D key
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used but required to implement KeyListener
    }
}
