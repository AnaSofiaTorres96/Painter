package grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    public Rectangle cursorRectangle;

    public Grid cursorGrid;
    private int posVer;

    private int posHor;

    //need to pass grid as arg because without it I dont have access to grid cellsize  + padding will look for better solution
    public Cursor (Grid cursorGrid){
        this.cursorGrid = cursorGrid;
        cursorRectangle = new Rectangle(cursorGrid.getPadding(),cursorGrid.getPadding(),cursorGrid.getCellSize(),cursorGrid.getCellSize());
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

    public void init(){
        while (true) {
            System.out.println("while");
            try {
                System.out.println("trycatch");
                Thread.sleep(1000);
                cursorBlinking();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cursorBlinking(){
        if(cursorRectangle.getColor() == Color.BLUE){
            System.out.println("if");
            cursorRectangle.setColor(Color.RED);
            cursorRectangle.draw();
            cursorRectangle.fill();
            return;
        }
        System.out.println("else");
        cursorRectangle.setColor(Color.BLUE);
        cursorRectangle.draw();
        cursorRectangle.fill();
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
