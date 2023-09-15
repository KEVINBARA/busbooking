package cashixpay.bus.travelroute.repository;

import cashixpay.bus.travelroute.entities.TravelRoute;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TravelRouteRepository extends JpaRepository<TravelRoute, UUID> {

        TravelRoute findBusRouteByName(String name);

        }
