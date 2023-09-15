package cashixpay.bus.travelschedule.repository;

import cashixpay.bus.travelschedule.entities.TravelSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TravelScheduleRepository extends JpaRepository<TravelSchedule, UUID> {


}
