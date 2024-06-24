package DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationCarDTO {

	private int reservation_id;
	private String username;
	private Date start_date;
	private Date end_date;
}
