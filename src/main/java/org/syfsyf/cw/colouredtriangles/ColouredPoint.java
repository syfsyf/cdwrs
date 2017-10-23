package org.syfsyf.cw.colouredtriangles;

/**
 * Created by mb on 2017-10-23.
 */
class ColouredPoint {
    public int[] position;
    public String color;

    public ColouredPoint(final int[] pos, final String color) {
        this.position = pos;
        this.color = color;
    }

    public int[] getPosition() {
        return position;
    }

    public String getColour() {
        return color;
    }

    @Override
    public String toString()     // String representation formated as "[[x, y], red]"
    {
        return "[[" + getPosition()[0] + "," + getPosition()[1] + "], " + getColour() + "]";
    }
}
