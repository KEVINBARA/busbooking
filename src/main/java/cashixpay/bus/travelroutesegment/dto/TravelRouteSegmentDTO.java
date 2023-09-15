package cashixpay.bus.travelroutesegment.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TravelRouteSegmentDTO {

    private String travelRouteId;
    private int segmentSequence;
    private String startStop;
    private String endStop;
}
