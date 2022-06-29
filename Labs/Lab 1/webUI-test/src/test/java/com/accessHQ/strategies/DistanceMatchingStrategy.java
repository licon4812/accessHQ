package com.accessHQ.strategies;

import com.accessHQ.models.Planet;

public class DistanceMatchingStrategy implements MatchingStrategy{
    private final long distance;

    public DistanceMatchingStrategy(long distance){
        this.distance = distance;
    }
    @Override
    public boolean match(Planet planet) {
        if(planet.getDistance().equals(distance)){
            return true;
        } else{
            return false;
        }
    }
}
