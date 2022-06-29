package com.accessHQ.strategies;

import com.accessHQ.models.Planet;

public class NameMatchingStrategy implements MatchingStrategy{
    private final String planetName;

    public NameMatchingStrategy(String planetName){
        this.planetName = planetName;
    }
    @Override
    public boolean match(Planet planet) {
        if(planet.getName().equalsIgnoreCase(planetName)) {

            return true;
        } else{
            return false;
        }
    }
}
