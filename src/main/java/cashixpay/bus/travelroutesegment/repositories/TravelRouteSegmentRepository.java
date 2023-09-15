package cashixpay.bus.travelroutesegment.repositories;

import cashixpay.bus.travelroutesegment.entities.TravelRouteSegment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TravelRouteSegmentRepository extends JpaRepository<TravelRouteSegment, UUID> {

    List<TravelRouteSegment> findTravelRouteSegmentByTravelRouteId(String routeId);

}
