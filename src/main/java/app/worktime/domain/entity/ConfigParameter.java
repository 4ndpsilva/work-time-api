package app.worktime.domain.entity;

import app.worktime.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "TB_CONFIG")
public class ConfigParameter extends BaseEntity<Long> {
    @Column(name = "TOTAL_WORKING_DAY")
    private LocalTime totalWorkingDay;
}