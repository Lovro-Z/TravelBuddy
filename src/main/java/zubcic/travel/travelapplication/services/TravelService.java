package zubcic.travel.travelapplication.services;

import zubcic.travel.travelapplication.dto.TravelItemDto;
import zubcic.travel.travelapplication.model.Travel;

import java.util.List;

public interface TravelService {

    Travel findTravelById(Long id);

    List<TravelItemDto> findAllTravels();

    Travel createTravel(TravelItemDto travelItemDto);
}
