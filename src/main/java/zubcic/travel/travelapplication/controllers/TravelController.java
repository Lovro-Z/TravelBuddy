package zubcic.travel.travelapplication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zubcic.travel.travelapplication.dto.TravelItemDto;
import zubcic.travel.travelapplication.model.Travel;
import zubcic.travel.travelapplication.services.TravelService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    public ResponseEntity<List<TravelItemDto>> getAllTravels() {
        return ResponseEntity.ok(travelService.findAllTravels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.findTravelById(id));
    }

    @PostMapping
    public ResponseEntity<Travel> createTravel(@RequestBody TravelItemDto travelDto) throws URISyntaxException {
        Travel travel = travelService.createTravel(travelDto);
        return ResponseEntity.created(new URI(travel.getId().toString())).body(travel);
    }
}
