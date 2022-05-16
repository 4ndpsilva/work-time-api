package app.worktime.domain.service;

import app.worktime.domain.dto.BalanceDTO;
import app.worktime.domain.entity.WorkingDay;
import app.worktime.infrastructure.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BalanceService {
    private final WorkingDayService workingDayService;
    private final ConfigParameterService configParameterService;

    public BalanceDTO calculate(final LocalDate startDate, final LocalDate endDate){
        final List<WorkingDay> list = workingDayService.find(Map.of("startDate", startDate, "endDate", endDate));

        List<LocalTime> balances = list.stream()
                .map(WorkingDay::getBalance)
                .collect(Collectors.toList());

        LocalTime total = TimeUtil.reduce(balances);

        BalanceDTO dto = new BalanceDTO();
        dto.setBalanceHours(total);
        return dto;
    }
}