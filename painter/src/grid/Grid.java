package grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


import java.util.ArrayList;
import java.util.Objects;


public class Grid {
    private int cols;

    private int rows;

    //public Rectangle grid;

    private int padding = 10;

    private Rectangle[][] cellList;

    public static final int cellSize = 15;

    public int getCellSize() {
        return this.cellSize;
    }


    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
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
    public Rectangle[][] getCellList() {
        return cellList;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public void paintOrEraseCell(int posVer, int posHor){

        if(cellList[posVer][posHor].isFilled()){
            //erase paint here
            cellList[posVer][posHor].setColor(Color.WHITE);
            cellList[posVer][posHor].fill();
            cellList[posVer][posHor].setColor(Color.BLACK);
            cellList[posVer][posHor].draw();


        }
        cellList[posHor][posVer].fill();
    }
}
