package club.maddm.common.result;

import lombok.Data;

/**
 * 异常返回
 */
@Data
public class ExceptionResult {
    private int status;//状态码
    private String message;//错误内容
    private Long timestamp;//时间戳

    public ExceptionResult(ExceptionStandard em) {
        this.status = em.getCod();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 异常转换接口
     */
    public interface ExceptionStandard{
        int getCod();
        String getMsg();
    }
}