package app.worktime.domain.entity;

import app.worktime.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "TB_WORKING_DAY")
public class WorkingDay extends BaseEntity<Long> {
    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "START_TIME")
    private LocalTime startTime;

    @Column(name = "END_TIME")
    private LocalTime endTime;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "REGISTERED")
    private boolean registered;
}