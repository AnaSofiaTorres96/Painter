package grid;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    Keyboard keyboard;

    Grid controlsGrid;

    Cursor gridCursor;
    public Controls(){
        init();
    }

    public Grid getControlsGrid() {
        return controlsGrid;
    }

    public void setControlsGrid(Grid controlsGrid) {
        this.controlsGrid = controlsGrid;
    }

    public Cursor getGridCursor() {
        return gridCursor;
    }

    public void setGridCursor(Cursor gridCursor) {
        this.gridCursor = gridCursor;
    }

    public Grid grid;

    public void init(){
        keyboard = new Keyboard(this);

        KeyboardEvent pressedW = new KeyboardEvent();
        pressedW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedW.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(pressedW);

        KeyboardEvent pressedS = new KeyboardEvent();
        pressedS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedS.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(pressedS);

        KeyboardEvent pressedD = new KeyboardEvent();
        pressedD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedD.setKey(KeyboardEvent.KEY_D);
        keyboard.addEventListener(pressedD);

        KeyboardEvent pressedA = new KeyboardEvent();
        pressedA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedA.setKey(KeyboardEvent.KEY_A);
        keyboard.addEventListener(pressedA);

        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressedSpace);

    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_W :
                if(gridCursor.getPosVer()==0){
                    break;
                }
                gridCursor.moveUp();
                break;

            case KeyboardEvent.KEY_S :
                if(gridCursor.getPosVer()==(controlsGrid.getCellList().length-1)){
                    break;
                }
                gridCursor.moveDown();
                break;

            case KeyboardEvent.KEY_D:
                if(gridCursor.getPosHor() == (controlsGrid.getCellList()[gridCursor.getPosHor()].length-1)){
                    break;
                }
                gridCursor.moveRight();
                break;

            case KeyboardEvent.KEY_A:
                if(gridCursor.getPosHor()==0){
                    break;
                }
                gridCursor.moveLeft();
                break;

            case KeyboardEvent.KEY_SPACE:
                controlsGrid.paintOrEraseCell(gridCursor.getPosVer(),gridCursor.getPosHor());
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
