package douglas.apiRestDoug.config;


import douglas.apiRestDoug.domain.Region;
import douglas.apiRestDoug.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final RegionRepository regionRepository;


    public DataLoader(RegionRepository regionRepository){
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}