package grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.io.*;

public class Grid {
    public Color currentColor;
    private int cols;
    private int rows;
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

        if(cellList[posHor][posVer].isFilled()){
            System.out.println("Erasing");
            cellList[posHor][posVer].setColor(Color.WHITE);
            cellList[posHor][posVer].fill();
            cellList[posHor][posVer].setColor(Color.BLACK);
            cellList[posHor][posVer].draw();
            return;

        }
        System.out.println("Painting");
        cellList[posHor][posVer].setColor(currentColor);
        cellList[posHor][posVer].fill();
    }


    public void clearGrid(){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cellList[i][j].setColor(Color.WHITE);
                cellList[i][j].fill();
                cellList[i][j].setColor(Color.BLACK);
                cellList[i][j].draw();
            }

        }
    }

    public boolean [][] convertGridToBooleanArr(Rectangle [][] grid){

        int gridRows = grid.length;
        int gridCols = grid[0].length;
        boolean [][] serializedGrid = new boolean[gridRows][gridCols];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j].isFilled()){
                    serializedGrid[i][j] = true;
                }
            }

        }
        return serializedGrid;

    }

    public void saveDrawing(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("savedDrawing.dat"));
            boolean [][] gridToBool = convertGridToBooleanArr(this.getCellList());

            out.writeObject(gridToBool);
            out.close();
            System.out.println("Drawing saved.");
        }catch(Exception e){
            System.out.println("Error save drawing."+ e.getMessage());
        }
    }




    public void loadDrawing(){
        try{
            FileInputStream fileIn = new FileInputStream("savedDrawing.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //how to make this return [][]
            boolean [][] boolArr = in.readAllBytes();


            redrawGrid(boolArr);
            System.out.println("Drawing loaded.");

        } catch (IOException |ClassNotFoundException e){
            System.out.println("Error loading drawing: " + e.getMessage());
        }
    }

    public void redrawGrid(boolean[][] boolArr){
       //recieve bool[][] redraw grid
        for (int i = 0; i < this.cellList.length; i++) {
            for (int j = 0; j < this.cellList[i].length; j++) {
                if(boolArr[i][j]){
                    this.cellList[i][j].setColor(currentColor);
                    this.cellList[i][j].fill();
                }
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
