package app.worktime.domain.service;

import app.worktime.core.service.BasicCrudService;
import app.worktime.domain.entity.ConfigParameter;
import app.worktime.domain.repository.ConfigParameterRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfigParameterService extends BasicCrudService<ConfigParameter, Long> {
    public ConfigParameterService(ConfigParameterRepository repository){
        super(repository, ConfigParameter.class);
    }
}