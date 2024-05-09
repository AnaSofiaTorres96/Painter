package grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    private Keyboard keyboard;

    private Grid controlsGrid;

    private Cursor gridCursor;

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



    public void init(){
        keyboard = new Keyboard(this);
        //MOVEMENT
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

        //PAINTING/CLEAR

        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressedSpace);

        KeyboardEvent pressedC = new KeyboardEvent();
        pressedC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedC.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(pressedC);

        //SAVING/LOADING

        KeyboardEvent pressedV = new KeyboardEvent();
        pressedV.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedV.setKey(KeyboardEvent.KEY_V);
        keyboard.addEventListener(pressedV);

        KeyboardEvent pressedL = new KeyboardEvent();
        pressedL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedL.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(pressedL);

        //COLOR CHANGES

        KeyboardEvent pressedToChangeToBlack = new KeyboardEvent();
        pressedToChangeToBlack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedToChangeToBlack.setKey(KeyboardEvent.KEY_0);
        keyboard.addEventListener(pressedToChangeToBlack);

        KeyboardEvent pressedToChangeToDarkGray = new KeyboardEvent();
        pressedToChangeToDarkGray.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedToChangeToDarkGray.setKey(KeyboardEvent.KEY_1);
        keyboard.addEventListener(pressedToChangeToDarkGray);

        KeyboardEvent pressedToChangeToGray = new KeyboardEvent();
        pressedToChangeToGray.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedToChangeToGray.setKey(KeyboardEvent.KEY_2);
        keyboard.addEventListener(pressedToChangeToGray);

        KeyboardEvent pressedToChangeToLightGray = new KeyboardEvent();
        pressedToChangeToLightGray.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedToChangeToLightGray.setKey(KeyboardEvent.KEY_3);
        keyboard.addEventListener(pressedToChangeToLightGray);

    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()){
            //MOVEMENT
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
            //PAINTING/CLEAR
            case KeyboardEvent.KEY_SPACE:
                controlsGrid.paintOrEraseCell(gridCursor.getPosVer(),gridCursor.getPosHor());
                break;

           /* case KeyboardEvent.KEY_C:
                controlsGrid.clearGrid();
                break;
            //SAVING/LOADING
            case KeyboardEvent.KEY_V:
                controlsGrid.saveDrawing();
                System.out.println("Saving drawing");
                break;

            case KeyboardEvent.KEY_L:
                controlsGrid.loadDrawing();
                System.out.println("Loading drawing");
                break;
            //COLORS
            case KeyboardEvent.KEY_0:
                controlsGrid.setCurrentColor(Color.BLACK);
                break;

            case KeyboardEvent.KEY_1:
                controlsGrid.setCurrentColor(Color.DARK_GRAY);
                break;

            case KeyboardEvent.KEY_2:
                controlsGrid.setCurrentColor(Color.GRAY);
                break;

            case KeyboardEvent.KEY_3:
                controlsGrid.setCurrentColor(Color.LIGHT_GRAY);

            */
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
