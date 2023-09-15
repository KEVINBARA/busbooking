package cashixpay.bus.travelroute.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TravelRouteDTO {


    private String busOwnerId;
    private String busId;
    private String name;
    private String startStop;
    private String endStop;
}
