package douglas.apiRestDoug.domain;

import jakarta.persistence.*;

@Embeddable
public class Rate {

    @Column(name = "number_cases")
    private int numberCases;

    @Column(name = "gross_rate")
    private Double grossRate;

    @Column(name = "adjusted_rate")
    private Double adjustedRate;

    public Rate() {

    }

    public Rate(int numberCases, Double grossRate, Double adjustedRate) {
        this.numberCases = numberCases;
        this.grossRate = grossRate;
        this.adjustedRate = adjustedRate;
    }

    public int getNumberCases() {
        return numberCases;
    }

    public void setNumberCases(int numberCases) {
        this.numberCases = numberCases;
    }

    public Double getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(Double grossRate) {
        this.grossRate = grossRate;
    }

    public Double getAdjustedRate() {
        return adjustedRate;
    }

    public void setAdjustedRate(Double adjustedRate) {
        this.adjustedRate = adjustedRate;
    }
}
