package org.syfsyf.cw.colouredtriangles;

import java.util.*;
import java.util.stream.Collectors;

class ColouredTriangles {


    static class Grouped {
        List<int[]> points = new ArrayList<>();

        public List<int[]> getPoints() {
            return points;
        }


    }

    static class Result implements Comparable<Result> {
        String color;
        int triangles;

        public int getTriangles() {
            return triangles;
        }


        @Override
        public int compareTo(Result o) {
            int r = triangles - o.triangles;
            if (r == 0) {
                return color.compareTo(o.color);
            }
            return r;
        }
    }

    public static TriangleResult countColouredTriangles(final List<ColouredPoint> lstPts) {

        //Map<String, List<ColouredPoint>> grouped = lstPts.stream().collect(Collectors.groupingBy(ColouredPoint::getColour));

        Map<String, Grouped> grouped = new HashMap<>();

        lstPts.forEach(p -> {
            String color = p.getColour();
            if (!grouped.containsKey(color)) {
                grouped.put(color, new Grouped());
            }
            grouped.get(color).points.add(p.getPosition());
        });


        final List<Result> results = new ArrayList<>();

        grouped.entrySet().stream().forEach(e -> {
            Result result = new Result();
            result.color = e.getKey();
            result.triangles = countTriangles(e.getValue());
            results.add(result);
        });


        int max = results.stream().mapToInt(Result::getTriangles).max().getAsInt();
        List<Result> sorted = results.stream().sorted().collect(Collectors.toList());

        int givenPoints = grouped.values().stream().map(Grouped::getPoints).mapToInt(List::size).sum();

        return new TriangleResult(givenPoints, grouped.size(), 11, Arrays.asList("red"), 10);
    }

    private static int countTriangles(Grouped value) {

        List<int[]> points = value.getPoints();
        if (points.size() <= 2) return 0;


        List<Integer> groupSize=new ArrayList<>();

        while (true){
            Set<Integer> alignedGroup = findAlignedGroup(points);
            if(alignedGroup.size()==0){
                for(int i=0;i<points.size();i++){
                    groupSize.add(1);
                }
                break;
            }
            alignedGroup.add(alignedGroup.size());

            List<int[]> tmp=new ArrayList<>();
            for(int i=0;i<points.size();i++){
                if(!alignedGroup.contains(i)){
                    tmp.add(points.get(i));
                }
            }
            points=tmp;
        }

        return new Random().nextInt(10);
    }

    private static Set<Integer> findAlignedGroup(List<int[]> points) {

        if(points.size()<=2){
            return Collections.emptySet();
        }
        Set<Integer> tmp=new HashSet<>();

        for(int i=0;i<points.size()-2;i++){
            int [] a=points.get(i);
            for(int j=i+1;j<points.size()-1;j++){
                int [] b=points.get(j);
                for(int k=j+1;k<points.size();k++)
                {
                    int [] c=points.get(k);
                    if(isAligned(a,b,c)){
                        tmp.add(i);
                        tmp.add(j);
                        tmp.add(k);
                    }
                }
                if(tmp.size()>0){
                    return tmp;
                }
            }
        }
        return Collections.emptySet();
    }

    public static boolean isAligned(int[] a, int[] b, int[] c) {

        int det = a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - b[0] * a[1] - a[0] * c[1] - c[0] * b[1];
        return det==0;
    }

}

