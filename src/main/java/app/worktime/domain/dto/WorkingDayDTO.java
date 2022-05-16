package app.worktime.domain.dto;

import app.worktime.infrastructure.util.ConstantUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class WorkingDayDTO implements Serializable {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    @JsonFormat(pattern = ConstantUtil.TIME_PATTERN)
    private LocalTime startTime;

    @NotNull
    @JsonFormat(pattern = ConstantUtil.TIME_PATTERN)
    private LocalTime endTime;

    @NotBlank
    private String description;

    private Boolean registered;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = ConstantUtil.TIME_PATTERN)
    private LocalTime balance;
}