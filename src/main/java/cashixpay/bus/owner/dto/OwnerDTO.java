package cashixpay.bus.owner.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OwnerDTO {

    private String name;

    private String address;

    private String phoneNumber;
}
