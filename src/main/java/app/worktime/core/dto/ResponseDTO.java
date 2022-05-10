package app.worktime.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO<T> {
    private T data;
    private List<T> dataSet;

    public ResponseDTO(final T data){
        this.data = data;
    }

    public ResponseDTO(final List<T> dataSet){
        this.dataSet = dataSet;
    }
}