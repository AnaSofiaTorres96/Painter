package grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    public Rectangle cursorRectangle;

    public Grid cursorGrid;
    private int posVer;

    private int posHor;

    public Cursor (){
        cursorRectangle = new Rectangle(10,10,15,15);
        cursorRectangle.setColor(Color.BLUE);
        cursorRectangle.draw();
        cursorRectangle.fill();
    }
    public void moveUp(){
        setPosVer(getPosVer()-1);

        cursorRectangle.translate(0,-cursorGrid.getCellSize());
    }
    public void moveDown(){
        setPosVer(getPosVer()+1);

        cursorRectangle.translate(0,cursorGrid.getCellSize());
    }

    public void moveLeft(){
        setPosHor(getPosHor()-1);

        cursorRectangle.translate(-cursorGrid.getCellSize(),0);
    }

    public void moveRight(){
        setPosHor(getPosHor()+1);

        cursorRectangle.translate(cursorGrid.getCellSize(),0);
    }

    public Grid getCursorGrid() {
        return cursorGrid;
    }

    public void setCursorGrid(Grid cursorGrid) {
        this.cursorGrid = cursorGrid;
    }

    public int getPosVer() {
        return posVer;
    }

    public void setPosVer(int posVer) {
        this.posVer = posVer;
    }

    public int getPosHor() {
        return posHor;
    }

    public void setPosHor(int posHor) {
        this.posHor = posHor;
    }
}
