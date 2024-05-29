package douglas.apiRestDoug.service;

import douglas.apiRestDoug.controller.dto.RegionDTO;
import douglas.apiRestDoug.domain.Rate;
import douglas.apiRestDoug.domain.Region;
import douglas.apiRestDoug.exception.RegionAlreadyExistsException;
import douglas.apiRestDoug.exception.RegionException;
import douglas.apiRestDoug.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Region saveRegion(RegionDTO regionDTO){
        var existentRegion = regionRepository.findByName(regionDTO.name());

        if (existentRegion.isPresent()) {
            throw new RegionAlreadyExistsException("Region data already exists. Check the possibility of updating, please!");
        }
        return regionRepository.save(regionDTO.doRegion());
    }

    public Optional<Region> findById(Long id) {
        return regionRepository.findById(id);
    }

    public Optional<Region> findByName(String name) {
        return regionRepository.findByName(name);
    }

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region updateRegion(Region region) {
        Optional<Region> regionFound = regionRepository.findById(region.getId());

        if (regionFound.isPresent()) {
            Region existingRegion = regionFound.get();
            existingRegion.setName(region.getName());
            existingRegion.setPopulation(region.getPopulation());
            existingRegion.setMalePopulation(region.getMalePopulation());

            Rate rate = existingRegion.getRate();

            rate.setNumberCases(region.getRate().getNumberCases());
            rate.setGrossRate(region.getRate().getGrossRate());
            rate.setAdjustedRate(region.getRate().getAdjustedRate());

            return regionRepository.save(existingRegion);
        }
        else {
            throw new RuntimeException("Region not found.");
        }
    }
    public void delete (Region region) {
        regionRepository.delete(region);
    }


}
