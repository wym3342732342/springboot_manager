package club.maddm.utils;

import ch.qos.logback.core.util.FileUtil;
import club.maddm.config.IpConfiguration;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author King
 * @version 1.0
 * @date 2019/12/17 16:57
 */
public class FileUtils {

    private static final String BASEROOT = System.getProperty("catalina.base")+File.separator+"uploadFiles";//tomcat实例子部署位置

    private static final String staticUrl = Objects.requireNonNull(FileUtils.class.getClassLoader().getResource("static")).getPath() + File.separator + "uploadFile";//类加载器

    /**
     * 获取存储文件名
     *
     * @param root
     * @return
     */
    public static String getName(String root) {
        //获取扩展
        String extName = root.substring(root.lastIndexOf("."));

        //防止重复时间戳
        String exName = TimeUtils.getFileName();

        return exName + extName;
    }

    /**
     * 文件上传工具
     *
     * @param path          路径
     * @param fileName      文件名
     * @param multipartFile 文件
     * @return
     */
    public static boolean uploadFile(String path, String fileName, MultipartFile multipartFile) {
        boolean isTrueUpload = true;

        if (/*useFtp!=null&&"1".equals(useFtp)*/false) {
            //上传到文件服务器
            /*try {
                InputStream inputStream = multipartFile.getInputStream();
                FTPUtil ftpUtils = new FTPUtil();
                isTrueUpload = ftpUtils.uploadFTPFile(FTPBASEROOT + path, fileName, inputStream);
            } catch (Exception e) {
                isTrueUpload = false;
                e.printStackTrace();
            }*/
        } else {
            try {
                //存放前判断路径是否存在
                File file = new File(staticUrl + path);
                if (!file.exists()) {
                    file.mkdirs();//不存在创建
                }
                //存储到指定位置
                multipartFile.transferTo(new File(staticUrl + path + fileName));
            } catch (IllegalStateException | IOException e) {
                isTrueUpload = false;
                e.printStackTrace();
            }
        }
        return isTrueUpload;
    }
    /**
     * 文件本地上传
     * @param path          路径
     * @param fileName      文件名
     * @param multipartFile 文件
     * @return 成功返回路径，不成功返回null
     */
    public static String localUploadFile(String path, String fileName, MultipartFile multipartFile) {
        String filePath = null;
        try {
            //存放前判断路径是否存在
            File file = new File(staticUrl + path);
            if (!file.exists()) {
                file.mkdirs();//不存在创建
            }
            //存储到指定位置
            multipartFile.transferTo(new File(staticUrl + path + fileName));
            filePath = localPreviewUrl(path,fileName);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return null;
        }
        return filePath;
    }

    /**
     * 返回预览url
     * @return
     * @param path 前缀路径
     * @param fileName 文件名
     */
    private static String localPreviewUrl(String path, String fileName) {
        return File.separator + "uploadFile" + path + fileName;
    }
}
