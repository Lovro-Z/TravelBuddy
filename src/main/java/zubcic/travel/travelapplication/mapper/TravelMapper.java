package zubcic.travel.travelapplication.mapper;

import org.springframework.stereotype.Component;
import zubcic.travel.travelapplication.dto.CreateTravelDto;
import zubcic.travel.travelapplication.model.Travel;

@Component
public class TravelMapper {

    public Travel toEntity(CreateTravelDto travelDto) {
        Travel travel = new Travel();
        travel.setTitle(travelDto.getTitle());
        travel.setDuration(travelDto.getDuration());
        travel.setDate(travelDto.getDate());
        travel.setPrice(travelDto.getPrice());
        travel.setDescription(travelDto.getDescription());
        return travel;
    }

    public CreateTravelDto toDto(Travel travel) {
        CreateTravelDto travelDto = new CreateTravelDto();
        travelDto.setTitle(travel.getTitle());
        travelDto.setDuration(travel.getDuration());
        travelDto.setDate(travel.getDate());
        travelDto.setPrice(travel.getPrice());
        travelDto.setDescription(travel.getDescription());
        return travelDto;
    }
}
