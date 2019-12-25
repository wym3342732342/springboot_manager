package club.maddm.common.result;

import club.maddm.common.entity.enums.ExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;//状态码
    private String message;//错误内容
    private Long timestamp;//时间戳

    public ExceptionResult(ExceptionEnum em) {
        this.status = em.getCod();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}