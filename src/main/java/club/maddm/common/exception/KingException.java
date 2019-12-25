package club.maddm.common.exception;

import club.maddm.common.entity.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class KingException extends RuntimeException {
    private ExceptionEnum exceptionEnum;

    public KingException() {
        this.exceptionEnum = ExceptionEnum.DEFOULT_ERROR;
    }
}