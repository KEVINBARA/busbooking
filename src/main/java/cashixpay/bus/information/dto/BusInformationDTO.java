package cashixpay.bus.information.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusInformationDTO {



    private String busOwnerReference;

    private String name;

    private int numberOfSeats;

    private String plateNumber;
}
