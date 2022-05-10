package app.worktime.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkingDayTest {

    @Test
    public void shouldCreateEntityObject(){
        WorkingDay entity = new WorkingDay();
        entity.setId(1L);
        entity.setDate(LocalDate.now());
        entity.setStartTime(LocalTime.now());
        entity.setEndTime(LocalTime.now());
        entity.setDescription("Teste de apontamento de horas");
        entity.setRegistered(false);

        Assertions.assertEquals(1L, entity.getId());
    }
}