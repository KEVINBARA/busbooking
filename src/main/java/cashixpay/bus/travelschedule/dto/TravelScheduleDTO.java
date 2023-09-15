package cashixpay.bus.travelschedule.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelScheduleDTO {


    private String busPlateNumber;
    private String routeId;
    private String routeName;
    private LocalDateTime startDateTime;
    private LocalDateTime arrivalDateTime;

}
