package app.worktime.core.repository.spec;

import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
public abstract class AbstractSpec<T> implements Specification<T> {
    private Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        final List<Predicate> predicates = new ArrayList<>();

        if(params.get("id") != null && !params.get("id").toString().isBlank()){
            final Long id = Long.valueOf(params.get("id").toString());
            predicates.add(builder.equal(root.get("id"), id));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}