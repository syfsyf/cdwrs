package org.syfsyf.cw.colouredtriangles;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ColouredTrianglesTests {




    List<List<ColouredPoint>> lstArguments = Arrays.asList(
            Arrays.asList(
                    new ColouredPoint(new int[]{3, -4}, "blue"),
                    new ColouredPoint(new int[]{-7, -1}, "red"),
                    new ColouredPoint(new int[]{7, -6}, "yellow"),
                    new ColouredPoint(new int[]{2, 5}, "yellow"),
                    new ColouredPoint(new int[]{1, -5}, "red"),
                    new ColouredPoint(new int[]{-1, 4}, "red"),
                    new ColouredPoint(new int[]{1, 7}, "red"),
                    new ColouredPoint(new int[]{-3, 5}, "red"),
                    new ColouredPoint(new int[]{-3, -5}, "blue"),
                    new ColouredPoint(new int[]{4, 1}, "blue")
            ),
            Arrays.asList(
                    new ColouredPoint(new int[]{3, -4}, "blue"),
                    new ColouredPoint(new int[]{-7, -1}, "red"),
                    new ColouredPoint(new int[]{7, -6}, "yellow"),
                    new ColouredPoint(new int[]{2, 5}, "yellow"),
                    new ColouredPoint(new int[]{1, -5}, "red"),
                    new ColouredPoint(new int[]{1, 1}, "red"),
                    new ColouredPoint(new int[]{1, 7}, "red"),
                    new ColouredPoint(new int[]{1, 4}, "red"),
                    new ColouredPoint(new int[]{-3, -5}, "blue"),
                    new ColouredPoint(new int[]{4, 1}, "blue")
            ),

            Arrays.asList(
                    new ColouredPoint(new int[]{1, -2}, "red"),
                    new ColouredPoint(new int[]{7, -6}, "yellow"),
                    new ColouredPoint(new int[]{2, 5}, "yellow"),
                    new ColouredPoint(new int[]{1, -5}, "red"),
                    new ColouredPoint(new int[]{1, 1}, "red"),
                    new ColouredPoint(new int[]{1, 7}, "red"),
                    new ColouredPoint(new int[]{1, 4}, "red"),
                    new ColouredPoint(new int[]{-3, -5}, "blue"),
                    new ColouredPoint(new int[]{4, 1}, "blue")
            )
    );

    List<TriangleResult> lstExpected =
            Arrays.asList(
                    new TriangleResult(10, 3, 11, Arrays.asList("red"), 10),
                    new TriangleResult(10, 3, 7, Arrays.asList("red"), 6),
                    new TriangleResult(9, 3, 0, new ArrayList<String>(), 0)
            );

    @Before
    public void setUp(){

      //  lstArguments=new ArrayList<>();
       // lstExpected=new ArrayList<>();




    }

    @Test
    public void test_BasicTests() {
        for (int n = 0; n < lstExpected.size(); n++) {

            assertEquals(lstExpected.get(n), ColouredTriangles.countColouredTriangles(lstArguments.get(n)));
            System.out.println("passed:" + n);
        }
    }

    @Test
    public void testAligned1(){
        int  a[]=new int[]{-1,-1};
        int  b[]=new int[]{1,1};
        int  c[]=new int[]{5,5};
        assertTrue(ColouredTriangles.isAligned(a,b,c));

    }
    @Test
    public void testAligned2(){
        int  a[]=new int[]{-1,-2};
        int  b[]=new int[]{1,1};
        int  c[]=new int[]{5,5};
        assertTrue(!ColouredTriangles.isAligned(a,b,c));

    }

}