package app.worktime.domain.mapper;

import app.worktime.core.mapper.GenericMapper;
import app.worktime.domain.dto.WorkingDayDTO;
import app.worktime.domain.entity.WorkingDay;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkingDayMapper extends GenericMapper<WorkingDay, WorkingDayDTO> { }