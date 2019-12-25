package club.maddm.common.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * 测试文件上传
 * @author King
 * @version 1.0
 * @date 2019/12/16 22:14
 */
@Data
@ApiModel(value="FileVO对象", description="文件VO ")
public class ReactFileVO {

    @ApiModelProperty(value = "主键")
    private String uid;

    @ApiModelProperty(value = "外键")
    private String resolveId;

    @ApiModelProperty(value = "原始文件名")
    private String fileName;

    @ApiModelProperty(value = "文件大小")
    private String fileSize;

    @ApiModelProperty(value = "原始文件路径")
    private String filePath;

    @ApiModelProperty(value = "缩略图路径")
    private String url;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "用途")
    private String purposeType;

    @ApiModelProperty(value = "文件上传状态")
    private String status;

    /**
     * 上传成功
     */
    public void successfull() {
        setStatus("done");
    }

    /**
     * 上传失败
     */
    public void error() {
        setStatus("error");
    }

    /**
     * 上传中
     */
    public void uploading() {
        setStatus("uploading");
    }
}
