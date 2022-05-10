package app.worktime.infrastructure.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private String codeMessage;
    private Object[] args;

    public BusinessException(final String codeMessage){
        super(codeMessage);
        this.codeMessage = codeMessage;
    }

    public BusinessException(final String codeMessage, final Object...args){
        this(codeMessage);
        this.args = args;
    }
}