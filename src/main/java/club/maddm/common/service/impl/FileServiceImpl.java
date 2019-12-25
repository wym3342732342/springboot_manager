package club.maddm.common.service.impl;

import club.maddm.common.entity.UserFile;
import club.maddm.common.entity.vo.ReactFileVO;
import club.maddm.common.exception.KingException;
import club.maddm.common.mapper.FileMapper;
import club.maddm.common.service.IBaseUploadService;
import club.maddm.common.service.IFileService;
import club.maddm.utils.FieldUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件表  服务实现类
 * </p>
 *
 * @author king
 * @since 2019-12-18
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, UserFile> implements IFileService {

    @Autowired
    private IBaseUploadService baseUploadService;

    /**
     * 头像上传
     * @param file
     * @param type
     * @return
     */
    @Transactional
    @Override
    public ReactFileVO uploadAvatar(MultipartFile file, String type) {

        ReactFileVO reactFileVO = baseUploadService.uploadImg(file, type);
        UserFile userFile = new UserFile();

        BeanUtils.copyProperties(reactFileVO,userFile);//对象拷贝

        try {
            FieldUtil.setAddFieldValue(userFile, "wang");
        } catch (Exception e) {
            e.printStackTrace();
        }

        save(userFile);//保存上传信息

        reactFileVO.setUid(userFile.getId());//给返回对象设置uid
        baseUploadService.setAddress(reactFileVO);//设置显示路径
        reactFileVO.successfull();//设置上传成功状态

        return reactFileVO;
    }
}
