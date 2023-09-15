package cashixpay.bus.travelroute.controller;


import cashixpay.bus.travelroute.entities.TravelRoute;
import cashixpay.bus.travelroute.service.TravelRouteService;
import cashixpay.bus.travelroute.dto.TravelRouteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/cashixpay/v1/travelroute")
public class TravelRouteController {

    private final TravelRouteService travelRouteService;

    public TravelRouteController(TravelRouteService travelRouteService) {
        this.travelRouteService = travelRouteService;
    }


    @GetMapping
    public List<TravelRoute> getTravelRoutes(){

        return travelRouteService.getTravelRoutes();
    }


    @PostMapping
    public TravelRoute addTravelRoute(@RequestBody TravelRouteDTO travelRouteDTO){

        return travelRouteService.addTravelRoute(travelRouteDTO);
    }
}
