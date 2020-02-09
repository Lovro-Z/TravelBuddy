package zubcic.travel.travelapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zubcic.travel.travelapplication.model.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long> {
}
