import grid.Controls;
import grid.Cursor;
import grid.Grid;

public class App {
    private Grid grid;

    private Controls controls;

    private Cursor cursor;

    public void init (int cols, int rows, int cellsize){
        grid = new Grid(cols, rows, cellsize);
        cursor = new Cursor(grid);
        controls = new Controls();

        controls.setControlsGrid(grid);
        controls.setGridCursor(cursor);
        cursor.init();

    }
}
