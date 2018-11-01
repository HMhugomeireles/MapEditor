package org.ac.mapeditor.grid;

import org.ac.mapeditor.pen.Pen;
import org.ac.mapeditor.stream.FileManager;

import java.util.Iterator;
import java.util.LinkedList;

public class Grid {

    public static final int CELL_WIDTH = 20;
    public static final int PADDING = 10;
    private int cols;
    private int rows;
    private int width;
    private int height;
    private Cell[][] position;
    private FileManager fileManager;

    public Grid(int cols, int rows) {
        width = cols * CELL_WIDTH;
        height = rows * CELL_WIDTH;
        this.cols = cols;
        this.rows = rows;

        position = new Cell[rows][cols];
        fileManager = new FileManager();
    }


    public void init() {

        // draw the cells
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                position[row][col] = new Cell(col, row);

            }
        }

        Pen pen = new Pen(this);


    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void paintCell(int col, int row) {

        // save cell paint
        Cell cell = position[row][col];


        if (cell.isPaint()) {
            cell.delete();
        } else {
            cell.paint();
        }

    }

    public void saveDocument() {

        String[] lines = new String[rows];

        for (int row = 0; row < rows; row++) {

            String line = "";

            for (int col = 0; col < cols; col++) {

                line += position[row][col].toString();

            }

            lines[row] = line;

        }

        // write document
        fileManager.save(lines);

    }

    public void openDocument() {

        String[] file = fileManager.open().split("\n");

        for (int row = 0; row < rows; row++) {

            String[] line = file[row].split("");

            for (int col = 0; col < cols; col++) {

                if (line[col].equals("1")) {
                    position[row][col].paint();
                } else {
                    position[row][col].delete();
                }
            }


        }

    }


    public boolean cellIsPaint(int col, int row) {

        return (position[row][col] != null);

    }

    public Cell getCellPosition(int col, int row) {
        return position[row][col];
    }

}
