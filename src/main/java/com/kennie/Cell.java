package com.kennie;

public class Cell {

    private int xAxis;
    private int yAxis;

    public Cell(int xAxis, int yAxis) {

        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (xAxis != cell.xAxis) return false;
        return yAxis == cell.yAxis;
    }

    @Override
    public int hashCode() {
        int result = xAxis;
        result = 31 * result + yAxis;
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "xAxis=" + xAxis +
                ", yAxis=" + yAxis +
                '}';
    }
}