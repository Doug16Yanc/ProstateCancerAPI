package douglas.apiRestDoug.controller.dto;

import douglas.apiRestDoug.domain.Rate;

public record RateDTO(
        int numberCases,
        Double grossRate,
        Double adjustedRate
) {
    public Rate toRate(){
        return new Rate(
                numberCases,
                grossRate,
                adjustedRate
        );
    }
}
