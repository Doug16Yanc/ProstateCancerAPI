package douglas.apiRestDoug.controller.dto;

import douglas.apiRestDoug.domain.Rate;

public record RateDTO(
    int numberCases,
    Double grossRate,
    Double adjustedRate
)
{
    public RateDTO() {
        this(0, 0.0, 0.0);
    }

    public RateDTO(int numberCases, Double grossRate, Double adjustedRate) {
        this.numberCases = numberCases;
        this.grossRate = grossRate;
        this.adjustedRate = adjustedRate;
    }

    public Rate toRate(){
        return new RateDTO(
                numberCases,
                grossRate,
                adjustedRate
        ).toRate();
    }
}
