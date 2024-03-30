package cashixpay.bus.travelroute.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TravelRouteDTO {


    private String busOwnerReference;
    private String name;
    private String reference;
    private String startStop;
    private String endStop;
}
