package app.worktime.domain.controller;

import app.worktime.core.mapper.GenericMapper;
import app.worktime.core.service.AbstractCrudService;
import app.worktime.domain.dto.BalanceDTO;
import app.worktime.domain.dto.WorkingDayDTO;
import app.worktime.domain.entity.WorkingDay;
import app.worktime.domain.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/work-time")
public class WorkingDayController {
    private final AbstractCrudService<WorkingDay, Long> service;
    private final BalanceService balanceService;
    private final GenericMapper<WorkingDay, WorkingDayDTO> mapper;

    @PostMapping
    public ResponseEntity<WorkingDayDTO> save(@RequestBody @Valid final WorkingDayDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(service.save(mapper.toEntity(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkingDayDTO> update(@PathVariable final Long id, @RequestBody @Valid final WorkingDayDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(service.update(id, mapper.toEntity(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkingDayDTO> findById(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<WorkingDayDTO>> find(@RequestParam final Map<String, Object> params) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toListDTO(service.find(params)));
    }

    @GetMapping("/balance-hours")
    public ResponseEntity<BalanceDTO> calculate(@RequestParam final String startDate, @RequestParam final String endDate) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(balanceService.calculate(LocalDate.parse(startDate), LocalDate.parse(endDate)));
    }
}