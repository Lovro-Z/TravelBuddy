package zubcic.travel.travelapplication.services;

import org.springframework.stereotype.Service;
import zubcic.travel.travelapplication.dto.TravelItemDto;
import zubcic.travel.travelapplication.mapper.TravelMapper;
import zubcic.travel.travelapplication.model.Travel;
import zubcic.travel.travelapplication.repositories.TravelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final TravelMapper travelMapper;

    public TravelServiceImpl(TravelRepository travelRepository, TravelMapper travelMapper) {
        this.travelRepository = travelRepository;
        this.travelMapper = travelMapper;
    }

    @Override
    public Travel findTravelById(Long id) {
        return travelRepository.findById(id).orElse(null);
    }

    @Override
    public List<TravelItemDto> findAllTravels() {
        return travelRepository.findAll()
                .stream()
                .map(travelMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
