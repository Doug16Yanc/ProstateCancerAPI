package douglas.apiRestDoug.controller;

import douglas.apiRestDoug.controller.dto.RateDTO;
import douglas.apiRestDoug.controller.dto.RegionDTO;
import douglas.apiRestDoug.domain.Region;
import douglas.apiRestDoug.domain.Rate;
import douglas.apiRestDoug.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService){
        this.regionService = regionService;
    }

    @PostMapping("/regions")
    public ResponseEntity<Region> toSaveRegion(@RequestBody RegionDTO regionDTO) {
        var region = regionService.saveRegion(regionDTO);

        return ResponseEntity.ok(region);
    }

    @GetMapping("/regions/{id}")
    public ResponseEntity<Region> findRegionById(@PathVariable("id") Long id){
        Optional<Region> regionFound = this.regionService.findById(id);

        if (regionFound.isPresent()){
            Region region = regionFound.get();
            return ResponseEntity.ok(region);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/regions/{name}")
    public ResponseEntity<Region> findRegionByName(@PathVariable("name") String name){
        Optional<Region> regionFound = this.regionService.findByName(name);

        if (regionFound.isPresent()){
            Region region = regionFound.get();
            return ResponseEntity.ok(region);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list_regions")
    public ResponseEntity<List<RegionDTO>> lisRegions() {
        List<Region> regions = regionService.findAll();
        List<RegionDTO> listRegionsDTO = new ArrayList<>();

        if (!regions.isEmpty()){
            for (Region region : regions) {

                listRegionsDTO.add(new RegionDTO(region.getName(), region.getPopulation(), region.getMalePopulation(), new Rate(region.getRate().getNumberCases(), region.getRate().getGrossRate(), region.getRate().getAdjustedRate())));
            }
            return ResponseEntity.ok(listRegionsDTO);
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/regions/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable("id") Long id, @RequestBody RegionDTO regionDTO) {
        Optional<Region> regionFound = regionService.findById(id);

        if (regionFound.isPresent()) {
            Region region = regionFound.get();
            region.setPopulation(regionDTO.population());
            region.setMalePopulation(regionDTO.malePopulation());

            Rate rate = new Rate();

            rate.setNumberCases(regionDTO.rate().getNumberCases());
            rate.setGrossRate((regionDTO.rate().getGrossRate()));
            rate.setAdjustedRate(regionDTO.rate().getAdjustedRate());

            Region updatedRegion = regionService.updateRegion(region);

            return ResponseEntity.ok(updatedRegion);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/regions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteRegionById(@PathVariable Long id) {
        Optional<Region> regionFound = regionService.findById(id);

        if (regionFound.isPresent()) {
            Region region = regionFound.get();
            regionService.delete(region);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Region " + region.getId() + " and " + region.getName() + " deleted successfully.");
        }
        else {
            throw new RuntimeException("Region not found.\n");
        }
    }
}
