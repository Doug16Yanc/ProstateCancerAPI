package douglas.apiRestDoug.controller.dto;

import douglas.apiRestDoug.domain.Rate;
import douglas.apiRestDoug.domain.Region;

public record RegionDTO(
        String name,
        int population,
        int malePopulation,
        RateDTO rateDTO
) {
    public Region doRegion(){
        return new Region(
                name,
                population,
                malePopulation,
                rateDTO.toRate()
        );
    }
}
