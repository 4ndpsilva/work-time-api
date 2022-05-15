package app.worktime.domain.dto;

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
    private LocalTime balanceHours;
    private LocalTime maxWorkingDayHours;
    private LocalTime minWorkingDayHours;
}