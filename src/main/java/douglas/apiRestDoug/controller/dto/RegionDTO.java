package douglas.apiRestDoug.controller.dto;

import douglas.apiRestDoug.domain.Rate;
import douglas.apiRestDoug.domain.Region;

public record RegionDTO(
        String name,
        int population,
        int malePopulation,
        Rate rate
) {
    public Region doRegion(){
        return new Region(
                name,
                population,
                malePopulation,
                rate
        );
    }
}
