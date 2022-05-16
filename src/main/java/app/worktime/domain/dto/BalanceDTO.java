package app.worktime.domain.dto;

import app.worktime.infrastructure.util.ConstantMSG;
import app.worktime.infrastructure.util.ConstantUtil;
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
    @JsonFormat(pattern = ConstantUtil.TIME_PATTERN)
    private LocalTime balanceHours = LocalTime.of(0, 0);

    @JsonFormat(pattern = ConstantUtil.TIME_PATTERN)
    private LocalTime maxWorkingDayHours = LocalTime.of(0, 0);;

    @JsonFormat(pattern = ConstantUtil.TIME_PATTERN)
    private LocalTime minWorkingDayHours = LocalTime.of(0, 0);;
}