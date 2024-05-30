package douglas.apiRestDoug.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tb_region_id", unique = true)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "population")
    private int population;
    @Column(name = "male_population")
    private int malePopulation;


    @Embedded
    private Rate rate;
    public Region() {

    }

    public Region(String name, int population, int malePopulation, Rate rate) {
        this.name = name;
        this.population = population;
        this.malePopulation = malePopulation;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getMalePopulation() {
        return malePopulation;
    }

    public void setMalePopulation(int malePopulation) {
        this.malePopulation = malePopulation;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}
