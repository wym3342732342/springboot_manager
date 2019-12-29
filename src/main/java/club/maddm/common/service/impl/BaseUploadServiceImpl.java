package club.maddm.common.service.impl;

import club.maddm.common.entity.excepyionEntity.ExceptionEnum;
import club.maddm.common.entity.vo.ReactFileVO;
import club.maddm.common.exception.KingException;
import club.maddm.common.service.IBaseUploadService;
import club.maddm.config.IpConfiguration;
import club.maddm.utils.FileUtils;
import club.maddm.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传实现
 * @author King
 * @version 1.0
 * @date 2019/12/18 08:58
 */
@Service
public class BaseUploadServiceImpl implements IBaseUploadService {

    @Autowired
    private IpConfiguration ipConfiguration;

    @Override
    public ReactFileVO uploadImg(MultipartFile file, String type) {
        //验证文件上传type是否正确

        if(file.isEmpty()){//文件为空跳过
            throw new KingException(ExceptionEnum.FILE_NOT_NULL);//上传文件空空
        }
        //单个文件不能大于10M
        if(file.getSize()>(10*1024*1024)){
            throw new KingException(ExceptionEnum.FILE_IS_TOO_LARGE);
        }
        //生成文件路径：类型 + 当前日期
        String path = File.separator + type + File.separator + TimeUtils.getFileName() + File.separator;

        //创建文件名称
        String fileName = FileUtils.getName(file.getOriginalFilename());

        //TODO 真实环境考虑返回文件对象，其中有缩略图路径等等
        String uploadFilePath
                = FileUtils.localUploadFile(path, fileName, file);//使用上传工具上传

        if (StringUtils.isBlank(uploadFilePath)) {
            throw new KingException(ExceptionEnum.FILE_UPLOAD_ERROR);//上传失败
        }

        ReactFileVO reactFileVO = new ReactFileVO();
        reactFileVO.setFileName(file.getOriginalFilename());
        reactFileVO.setUrl(uploadFilePath);//缩略图
        reactFileVO.setFilePath(uploadFilePath);//原始文件图片
        reactFileVO.setFileSize(file.getSize() + "");
        reactFileVO.setFileType("phone");
        reactFileVO.setPurposeType(type);
        //reactFileVO.setStatus("done");//文件上传成功

        return reactFileVO;
    }

    /**
     * 设置访问地址
     * @param reactFileVO 需要返回给客户端的vo
     */
    @Override
    public void setAddress(ReactFileVO reactFileVO) {
        reactFileVO.setUrl(ipConfiguration.getAddress() + reactFileVO.getUrl());
        reactFileVO.setFilePath(ipConfiguration.getAddress() + reactFileVO.getFilePath());
    }
}
