package org.ac.mapeditor.pen;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PenKeyboard implements KeyboardHandler {

    private Pen pen;

    public PenKeyboard(Pen pen) {

        this.pen = pen;

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent open = new KeyboardEvent();
        open.setKey(KeyboardEvent.KEY_O);
        open.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(open);
    }


    @Override
    public void keyPressed(KeyboardEvent keyEvent) {

        switch (keyEvent.getKey()) {
            case (KeyboardEvent.KEY_LEFT):
                pen.moveLeft();
                break;
            case (KeyboardEvent.KEY_RIGHT):
                pen.moveRight();
                break;
            case (KeyboardEvent.KEY_UP):
                pen.moveUp();
                break;
            case (KeyboardEvent.KEY_DOWN):
                pen.moveDown();
                break;
            case (KeyboardEvent.KEY_SPACE):
                pen.paint();
                break;
            case (KeyboardEvent.KEY_S):
                pen.saveDocument();
                break;
            case (KeyboardEvent.KEY_O):
                pen.openDocument();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
