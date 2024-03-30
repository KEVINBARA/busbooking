package cashixpay.bus.seatinventory.pojo;


import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class AvailableTravelSchedule {

    private String travelScheduleId;

    private String ownerRef;
    private Long seatLeft;

    private String startStop;

    private String endStop;

    private int routeSegment;

    private LocalDateTime travelDateTime;
    private LocalDateTime arrivalDateTime;

}
