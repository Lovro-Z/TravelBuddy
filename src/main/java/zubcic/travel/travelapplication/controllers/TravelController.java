package zubcic.travel.travelapplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zubcic.travel.travelapplication.model.Travel;
import zubcic.travel.travelapplication.services.TravelService;

import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    List<Travel> getAllTravels() {
        return travelService.findAllTravels();
    }

    @GetMapping("/{id}")
    Travel getTravelById(@PathVariable Long id) {
        return travelService.findTravelById(id);
    }
}
