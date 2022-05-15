package app.worktime.domain.service;

import app.worktime.core.service.BasicCrudService;
import app.worktime.domain.entity.WorkingDay;
import app.worktime.domain.repository.WorkingDayRepository;
import app.worktime.domain.repository.spec.WorkingDaySpec;
import app.worktime.infrastructure.exception.BusinessException;
import app.worktime.infrastructure.util.ConstantMSG;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WorkingDayService extends BasicCrudService<WorkingDay, Long> {
    private WorkingDayRepository repository;
    private ConfigParameterService configParameterService;

    public WorkingDayService(WorkingDayRepository repository, WorkingDaySpec spec, ConfigParameterService configParameterService) {
        super(repository, spec, WorkingDay.class);

        this.repository = repository;
        this.configParameterService = configParameterService;
    }

    @Override
    public WorkingDay update(Long id, WorkingDay updateEntity) {
        updateEntity.setId(id);
        return super.update(id, updateEntity);
    }

    @Override
    public void validate(final WorkingDay entity) {
        validateHours(entity);
        validateInterval(entity);
    }

    private void validateHours(final WorkingDay entity) {
        final LocalTime startTime = entity.getStartTime();
        final LocalTime endTime = entity.getEndTime();

        if (startTime.compareTo(endTime) > 0) {
            throw new BusinessException(ConstantMSG.API_008);
        }
    }

    private void validateInterval(final WorkingDay entity) {
        final LocalDate date = entity.getDate();
        List<WorkingDay> list = this.find(Map.of("startDate", date, "endDate", date));

        list = list.stream()
                .sorted(Comparator.comparing(WorkingDay::getStartTime))
                .collect(Collectors.toList());

        if(entity.getId() != null && entity.getId() > 0) {
            list = list.stream()
                    .filter(e -> e.getId() != entity.getId())
                    .collect(Collectors.toList());
        }

        list.forEach(e -> verifyInterval(e, entity));
    }

    private void verifyInterval(final WorkingDay entity, final WorkingDay newEntity){
        final LocalTime startTime = newEntity.getStartTime();
        final LocalTime endTime = newEntity.getEndTime();

        if (startTime.compareTo(entity.getStartTime()) < 0 && endTime.compareTo(entity.getStartTime()) > 0) {
            throw new BusinessException(ConstantMSG.API_001);
        }

        if (startTime.compareTo(entity.getStartTime()) > 0 && startTime.compareTo(entity.getEndTime()) < 0) {
            throw new BusinessException(ConstantMSG.API_001);
        }

        if (startTime.compareTo(entity.getStartTime()) <= 0 && endTime.compareTo(entity.getEndTime()) >= 0) {
            throw new BusinessException(ConstantMSG.API_001);
        }

        if (startTime.compareTo(entity.getStartTime()) >= 0 && endTime.compareTo(entity.getEndTime()) <= 0) {
            throw new BusinessException(ConstantMSG.API_001);
        }
    }
}