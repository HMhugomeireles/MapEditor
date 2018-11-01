package org.ac.mapeditor.pen;

import org.ac.mapeditor.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pen {

    private Grid grid;
    private PenKeyboard penKeyboard;
    private Rectangle penRec;


    public Pen(Grid grid) {

        this.grid = grid;

        penKeyboard = new PenKeyboard(this);

        penRec = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.CELL_WIDTH, Grid.CELL_WIDTH);
        penRec.setColor(Color.BLUE);
        penRec.fill();

    }

    public void moveLeft() {

        if (penRec.getX() > Grid.PADDING) {
            penRec.translate(-Grid.CELL_WIDTH, 0);
        }
    }

    public void moveRight() {

        if (penRec.getX() < grid.getWidth() + Grid.PADDING - Grid.CELL_WIDTH) {
            penRec.translate(Grid.CELL_WIDTH, 0);
        }
    }

    public void moveUp() {

        if (penRec.getY() > Grid.PADDING) {
            penRec.translate(0, -Grid.CELL_WIDTH);
        }
    }

    public void moveDown() {

        if (penRec.getY() < grid.getHeight() + Grid.PADDING - Grid.CELL_WIDTH) {
            penRec.translate(0, Grid.CELL_WIDTH);
        }
    }

    public void paint() {

        int currentCol = (penRec.getX() - Grid.PADDING) / Grid.CELL_WIDTH;
        int currentRow = (penRec.getY() - Grid.PADDING) / Grid.CELL_WIDTH;

        grid.paintCell(currentCol, currentRow );

    }

    public void saveDocument(){
        grid.saveDocument();
    }

    public void openDocument(){
        grid.openDocument();
        System.out.println("open");
    }

    @Override
    public String toString() {
        return "pen x -> " + penRec.getX()
                + " pen y -> " + penRec.getY()
                + " pen col -> " + ((penRec.getX() / Grid.CELL_WIDTH) - (Grid.PADDING / Grid.CELL_WIDTH))
                + " pen row -> " + ((penRec.getY() / Grid.CELL_WIDTH) - (Grid.PADDING / Grid.CELL_WIDTH));
    }
}
