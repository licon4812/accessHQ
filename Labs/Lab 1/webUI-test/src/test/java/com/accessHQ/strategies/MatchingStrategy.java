package com.accessHQ.strategies;

import com.accessHQ.models.Planet;

public interface MatchingStrategy {
    boolean match(Planet planet);
}
