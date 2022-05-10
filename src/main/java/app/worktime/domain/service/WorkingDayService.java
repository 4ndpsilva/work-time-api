package app.worktime.domain.service;

import app.worktime.core.service.BasicCrudService;
import app.worktime.domain.entity.WorkingDay;
import app.worktime.domain.repository.WorkingDayRepository;
import app.worktime.domain.repository.spec.WorkingDaySpec;
import org.springframework.stereotype.Service;

@Service
public class WorkingDayService extends BasicCrudService<WorkingDay, Long> {
    public WorkingDayService(WorkingDayRepository repository, WorkingDaySpec spec){
        super(repository, spec, WorkingDay.class);
    }
}