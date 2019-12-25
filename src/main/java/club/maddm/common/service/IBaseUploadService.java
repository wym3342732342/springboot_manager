package club.maddm.common.service;

import club.maddm.common.entity.vo.ReactFileVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * 基础上传服务
 * @author King
 * @version 1.0
 * @date 2019/12/18 08:56
 */
public interface IBaseUploadService {
    /**
     * 图片上传服务
     * @param file 传入的文件
     * @param type 图片类型：是否是头像
     * @return
     */
    ReactFileVO uploadImg(MultipartFile file,String type);

    /**
     * 给需要返回的vo设置文件访问地址
     * @param reactFileVO
     */
    void setAddress(ReactFileVO reactFileVO);
}
