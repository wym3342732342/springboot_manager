package club.maddm.common.service;

import club.maddm.common.entity.UserFile;
import club.maddm.common.entity.vo.ReactFileVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件表  服务类
 * </p>
 *
 * @author king
 * @since 2019-12-18
 */
public interface IFileService extends IService<UserFile> {

    ReactFileVO uploadAvatar(MultipartFile file, String type);
}
