package club.maddm.common.exception;

import club.maddm.common.entity.excepyionEntity.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KingException extends RuntimeException {
    private ExceptionEnum exceptionEnum;

    public KingException() {
        this.exceptionEnum = ExceptionEnum.DEFOULT_ERROR;
    }
}