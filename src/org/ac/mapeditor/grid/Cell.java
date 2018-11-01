package org.ac.mapeditor.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private Rectangle rectangle;
    private int col;
    private int row;
    private boolean paint;

    public Cell(int col, int row) {

        this.col = col;
        this.row = row;
        paint = false;

        init();
    }

    private void init() {

        rectangle = new Rectangle(Grid.PADDING + (col * Grid.CELL_WIDTH), Grid.PADDING + (row * Grid.CELL_WIDTH), Grid.CELL_WIDTH , Grid.CELL_WIDTH );
        rectangle.setColor(Color.BLACK);
        rectangle.draw();

    }

    public void paint() {
        rectangle.fill();
        paint = true;
    }

    public void delete() {
        rectangle.draw();
        paint = false;
    }

    public boolean isPaint() {
        return paint;
    }

    @Override
    public String toString() {
        return  (isPaint()) ? "1" : "0";
    }

}
