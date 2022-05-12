package app.worktime.domain.mapper;

import app.worktime.core.mapper.GenericMapper;
import app.worktime.domain.dto.ConfigParameterDTO;
import app.worktime.domain.entity.ConfigParameter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConfigParameterMapper extends GenericMapper<ConfigParameter, ConfigParameterDTO> { }