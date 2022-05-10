package app.worktime.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "TB_WORKING_DAY")
public class WorkingDay {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
}