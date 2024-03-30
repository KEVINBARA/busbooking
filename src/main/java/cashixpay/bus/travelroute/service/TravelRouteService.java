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


        String reference = getRouteReference(travelRouteDTO.getBusOwnerReference(),travelRouteDTO.getName());
        TravelRoute travelRoute = TravelRoute.builder()
                .busOwnerReference(travelRouteDTO.getBusOwnerReference())
                .name(travelRouteDTO.getName())
                .reference(reference)
                .startStop(travelRouteDTO.getStartStop())
                .endStop(travelRouteDTO.getEndStop()).build();

        travelRouteRepository.save(travelRoute);

        return travelRoute;
    }

    private String getRouteReference(String busOwnerReference,String routeName){

        return busOwnerReference+"-"+routeName;
    }

    public List<TravelRoute> getTravelRoutes(){

        return travelRouteRepository.findAll();
    }
}
