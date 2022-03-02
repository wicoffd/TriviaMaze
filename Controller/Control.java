package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/** This will control how the sprite moves. This will also ensure that we dont go out of bounds or do illegal stuff. */
public class Control {
    private class MyKeyAdapter extends KeyAdapter {
        public void myKeyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    // move left
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    // move right
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    // move up
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    // move down
                    break;
                // no default class if no input, do nothing.
            }
        }
    }
}
