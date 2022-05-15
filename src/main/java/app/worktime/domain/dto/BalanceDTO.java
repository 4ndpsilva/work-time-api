package app.worktime.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDTO implements Serializable {
    @JsonFormat(pattern = "HH:mm")
    private LocalTime balanceHours;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime maxWorkingDayHours;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime minWorkingDayHours;
}