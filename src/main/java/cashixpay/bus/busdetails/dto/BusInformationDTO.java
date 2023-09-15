package cashixpay.bus.busdetails.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusInformationDTO {


    private String busOwnerId;

    private String name;

    private int numberOfSeats;

    private String plateNumber;
}
