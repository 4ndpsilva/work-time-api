package app.worktime.domain.service;

import app.worktime.domain.dto.BalanceDTO;
import app.worktime.domain.entity.WorkingDay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BalanceService {
    private final WorkingDayService workingDayService;
    private final ConfigParameterService configParameterService;

    public BalanceDTO calculate(final LocalDate startDate, final LocalDate endDate){
        final LocalTime totalWorkingDay = configParameterService.findById(1L).getTotalWorkingDay();
        final List<WorkingDay> list = workingDayService.find(Map.of("startDate", startDate, "endDate", endDate));

        return null;
    }
}