package thonguyenvan.interviewms.util.dto.offer;

import lombok.*;
import thonguyenvan.interviewms.enums.offer.OfferStatus;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferListDTO {
    private Integer id;

    private String note;

    private OfferStatus offerStatus;


}
