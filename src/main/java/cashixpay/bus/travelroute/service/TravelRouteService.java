package cashixpay.bus.travelroute.service;

import cashixpay.bus.travelroute.dto.TravelRouteDTO;
import cashixpay.bus.travelroute.entities.TravelRoute;
import cashixpay.bus.travelroute.repository.TravelRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelRouteService {

    @Autowired
    private TravelRouteRepository travelRouteRepository;


    public TravelRoute addTravelRoute(TravelRouteDTO travelRouteDTO){

        TravelRoute travelRoute = TravelRoute.builder()
                .busOwnerId(travelRouteDTO.getBusOwnerId())
                .busId(travelRouteDTO.getBusId())
                .name(travelRouteDTO.getName())
                .startStop(travelRouteDTO.getStartStop())
                .endStop(travelRouteDTO.getEndStop()).build();

        travelRouteRepository.save(travelRoute);

        return travelRoute;
    }

    public List<TravelRoute> getTravelRoutes(){

        return travelRouteRepository.findAll();
    }
}
