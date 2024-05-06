import grid.Controls;
import grid.Cursor;
import grid.Grid;

public class Main {
    public static void main(String[] args) {

        Grid test = new Grid(30,30);
        Controls testControls = new Controls();
        Cursor testCursor = new Cursor();

        testCursor.setCursorGrid(test);
        testControls.setControlsGrid(test);
        testControls.setGridCursor(testCursor);


    }
}
