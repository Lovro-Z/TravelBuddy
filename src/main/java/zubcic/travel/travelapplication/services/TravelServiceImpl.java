package zubcic.travel.travelapplication.services;

import org.springframework.stereotype.Service;
import zubcic.travel.travelapplication.model.Travel;
import zubcic.travel.travelapplication.repositories.TravelRepository;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;

    public TravelServiceImpl(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    @Override
    public Travel findTravelById(Long id) {
        return travelRepository.findById(id).get();
    }

    @Override
    public List<Travel> findAllTravels() {
        return travelRepository.findAll();
    }
}
