package zubcic.travel.travelapplication.mapper;

import org.springframework.stereotype.Component;
import zubcic.travel.travelapplication.dto.TravelItemDto;
import zubcic.travel.travelapplication.model.Travel;

@Component
public class TravelMapper {

    public Travel toEntity(TravelItemDto travelItemDto) {
        Travel travel = new Travel();
        travel.setTitle(travelItemDto.getTitle());
        travel.setDuration(travelItemDto.getDuration());
        travel.setDate(travelItemDto.getDate());
        travel.setPrice(travelItemDto.getPrice());
        return travel;
    }

    public TravelItemDto entityToDto(Travel travel) {
        TravelItemDto travelDto = new TravelItemDto();
        travelDto.setTitle(travel.getTitle());
        travelDto.setDuration(travel.getDuration());
        travelDto.setDate(travel.getDate());
        travelDto.setPrice(travel.getPrice());
        return travelDto;
    }
}
