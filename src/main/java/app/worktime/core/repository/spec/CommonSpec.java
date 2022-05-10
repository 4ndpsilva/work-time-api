package app.worktime.core.repository.spec;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class CommonSpec<T> {
    public Specification<T> equal(String field, Object value){
        return (root, criteriaQuery, cb) -> cb.equal(root.get(field), value);
    }

    public Specification<T> notEqual(String field, Object value){
        return (root, criteriaQuery, cb) -> cb.notEqual(root.get(field), value);
    }

    public Specification<T> like(String field, Object value){
        return (root, criteriaQuery, cb) -> cb.like(cb.lower(root.get(field)), "%"+value.toString().toLowerCase()+"%");
    }

    public Specification<T> notLike(String field, Object value){
        return (root, criteriaQuery, cb) -> cb.notLike(cb.lower(root.get(field)), "%"+value.toString().toLowerCase()+"%");
    }

    public Specification<T> between(String field, LocalDate startDate, LocalDate endDate){
        return (root, criteriaQuery, cb) -> cb.between(root.get(field), startDate, endDate);
    }

    public Specification<T> between(String field, BigDecimal startValue, BigDecimal endValue){
        return (root, criteriaQuery, cb) -> cb.between(root.get(field), startValue, endValue);
    }

    public Specification<T> in(String field, List<?> values){
        return (root, criteriaQuery, cb) -> cb.in(root.get(field)).value(values);
    }
}