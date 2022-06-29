package com.accessHQ.strategies;

import com.accessHQ.models.Planet;
import com.accessHQ.models.PlanetPage;

public class RadiusMatchingStrategy implements MatchingStrategy{
    private final double radius;

    public RadiusMatchingStrategy(double radius){
        this.radius= radius;
    }
    @Override
    public boolean match(Planet planet) {
        if(planet.getRadius().equals(radius)){
            return true;
        } else{
            return false;
        }
    }
}
