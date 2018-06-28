package com.sadiq;

import static java.lang.Math.*;



public class Distance {
    float getSqrtDistance(Point point1, Point point2){


        return (float) sqrt(pow(abs(point1.x - point2.x),2) + pow(abs(point1.y - point2.y),2) );
    }

    float getManhattanDistance(Point point1, Point point2 ){
        return (float) abs(point1.x - point2.x) + abs(point1.y - point2.y);
    }
}
