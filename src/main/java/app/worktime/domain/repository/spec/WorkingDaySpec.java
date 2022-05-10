package app.worktime.domain.repository.spec;

import app.worktime.core.repository.spec.AbstractSpec;
import app.worktime.domain.entity.WorkingDay;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Component
public class WorkingDaySpec extends AbstractSpec<WorkingDay> {
    private Map<String, Object> params;
    @Override
    public Predicate toPredicate(Root<WorkingDay> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        super.setParams(params);
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(super.toPredicate(root, query, builder));

        if(params.get("startDate") != null){
            final LocalDate startDate = LocalDate.parse(params.get("startDate").toString());
            LocalDate endDate = LocalDate.now();

            if(params.get("endDate") != null){
                endDate = LocalDate.parse(params.get("endDate").toString());
            }

            predicates.add(builder.between(root.get("date"), startDate, endDate));
        }

        final Object description = params.get("description");

        if(description != null && !description.toString().isBlank()){
            predicates.add(builder.like(builder.lower(root.get("description")), "%"+description.toString().toLowerCase()+"%"));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}