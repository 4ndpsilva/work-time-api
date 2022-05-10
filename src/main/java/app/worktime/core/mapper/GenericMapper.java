package app.worktime.core.mapper;

import java.util.List;

public interface GenericMapper<T, D> {
    T toEntity(D dto);

    D toDTO(T entity);

    List<D> toListDTO(List<T> entities);
}