package douglas.apiRestDoug.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tb_rate_id", unique = true)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
