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

@Service
public class WorkingDayService extends BasicCrudService<WorkingDay, Long> {
    private WorkingDayRepository repository;

    public WorkingDayService(WorkingDayRepository repository, WorkingDaySpec spec){
        super(repository, spec, WorkingDay.class);

        this.repository = repository;
    }

    @Override
    public void validate(final WorkingDay entity) {
        validateHours(entity);
        validateInterval(entity);
    }

    private void validateHours(final WorkingDay entity) {
        final LocalTime startTime = entity.getStartTime();
        final LocalTime endTime = entity.getEndTime();

        if(startTime.compareTo(endTime) > 0){
            throw new BusinessException(ConstantMSG.API_008);
        }
    }
    private void validateInterval(final WorkingDay entity) {
        final LocalDate date = entity.getDate();
        final LocalTime startTime = entity.getStartTime();
        final LocalTime endTime = entity.getEndTime();

        repository.findAll().forEach(w -> {
            if(date.compareTo(w.getDate()) == 0){
                if(startTime.compareTo(w.getStartTime()) == 0){
                    throw new BusinessException(ConstantMSG.API_001);
                }

                if(endTime.compareTo(w.getStartTime()) == 0){
                    throw new BusinessException(ConstantMSG.API_001);
                }

                if(startTime.compareTo(w.getStartTime()) > 0 && startTime.compareTo(w.getEndTime()) < 0) {
                    throw new BusinessException(ConstantMSG.API_001);
                }

                if(startTime.compareTo(w.getStartTime()) <= 0 && endTime.compareTo(w.getEndTime()) >= 0) {
                    throw new BusinessException(ConstantMSG.API_001);
                }

                if(startTime.compareTo(w.getStartTime()) >= 0 && endTime.compareTo(w.getEndTime()) <= 0) {
                    throw new BusinessException(ConstantMSG.API_001);
                }
            }
        });
    }
}