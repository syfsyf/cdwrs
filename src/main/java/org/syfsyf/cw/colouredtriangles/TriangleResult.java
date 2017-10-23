package org.syfsyf.cw.colouredtriangles;

import java.util.List;

/**
 * Created by mb on 2017-10-23.
 * http://www.codewars.com/kata/57cebf1472f98327760003cd/train/java
 */
class TriangleResult {
    int nGivenPoints;
    int nGivenColours;
    int nTriangles;
    List<String> colours;
    int maxFromColour;

    public TriangleResult() {
    }

    public TriangleResult(int nGivenPoints, int nGivenColours, int nTriangles, List<String> colours, int maxFromColour) {
        this.nGivenPoints = nGivenPoints;
        this.nGivenColours = nGivenColours;
        this.nTriangles = nTriangles;
        this.colours = colours;
        this.maxFromColour = maxFromColour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriangleResult that = (TriangleResult) o;

        if (nGivenPoints != that.nGivenPoints) return false;
        if (nGivenColours != that.nGivenColours) return false;
        if (nTriangles != that.nTriangles) return false;
        if (maxFromColour != that.maxFromColour) return false;
        return colours != null ? colours.equals(that.colours) : that.colours == null;
    }

    @Override
    public int hashCode() {
        int result = nGivenPoints;
        result = 31 * result + nGivenColours;
        result = 31 * result + nTriangles;
        result = 31 * result + (colours != null ? colours.hashCode() : 0);
        result = 31 * result + maxFromColour;
        return result;
    }

    @Override
    public String toString() {
        return "TriangleResult{" +
                "nGivenPoints=" + nGivenPoints +
                ", nGivenColours=" + nGivenColours +
                ", nTriangles=" + nTriangles +
                ", colours=" + colours +
                ", maxFromColour=" + maxFromColour +
                '}';
    }
}
