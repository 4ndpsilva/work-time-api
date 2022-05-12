package app.worktime.domain.controller;

import app.worktime.core.mapper.GenericMapper;
import app.worktime.core.service.AbstractCrudService;
import app.worktime.domain.dto.ConfigParameterDTO;
import app.worktime.domain.entity.ConfigParameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/work-time/config")
public class ConfigParameterController {
    private final AbstractCrudService<ConfigParameter, Long> service;
    private final GenericMapper<ConfigParameter, ConfigParameterDTO> mapper;

    @PostMapping
    public ResponseEntity<ConfigParameterDTO> save(@RequestBody @Valid final ConfigParameterDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(service.save(mapper.toEntity(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfigParameterDTO> update(@PathVariable final Long id, @RequestBody @Valid final ConfigParameterDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(service.update(id, mapper.toEntity(dto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfigParameterDTO> findById(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ConfigParameterDTO>> find(@RequestParam final Map<String, Object> params) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toListDTO(service.find(params)));
    }
}