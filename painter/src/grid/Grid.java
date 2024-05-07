package grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


import java.util.ArrayList;
import java.util.Objects;


public class Grid {

    private Color currentColor;
    private int cols;

    private int rows;

    //public Rectangle grid;

    private int padding = 10;

    private Rectangle[][] cellList;

    private int cellSize;


    public Grid(int cols, int rows, int cellSize) {
        this.currentColor = Color.BLACK;
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        cellList = new Rectangle[cols][rows];
        gridConstruction();

    }
    public void gridConstruction() {

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                cellList[i][j] = new Rectangle(padding + cellSize * i, padding + cellSize * j, cellSize, cellSize);
                cellList[i][j].draw();

            }

        }
    }

    public void paintOrEraseCell(int posVer, int posHor){
        System.out.println("this is the paint erase method");

        if(cellList[posHor][posVer].isFilled()){
            System.out.println("paint erasing");
            cellList[posHor][posVer].setColor(Color.WHITE);
            cellList[posHor][posVer].fill();
            cellList[posHor][posVer].setColor(currentColor);
            cellList[posHor][posVer].draw();
            return;

        }
        System.out.println("painting");
        cellList[posHor][posVer].setColor(currentColor);
        cellList[posHor][posVer].fill();
    }


    public void clearBoard(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cellList[i][j].setColor(Color.WHITE);
                cellList[i][j].fill();
                cellList[i][j].setColor(Color.BLACK);
                cellList[i][j].draw();
            }

        }
    }
//GETTERS/SETTERS
    public int getCellSize() {
    return this.cellSize;
    }
    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }
    public Rectangle[][] getCellList() {
        return cellList;
    }

    public int getPadding() {
        return padding;
    }
}
