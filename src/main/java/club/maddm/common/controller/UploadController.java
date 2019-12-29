package club.maddm.common.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import club.maddm.common.entity.excepyionEntity.ExceptionEnum;
import club.maddm.common.entity.vo.ReactFileVO;
import club.maddm.common.exception.KingException;
import club.maddm.config.IpConfiguration;
import club.maddm.utils.FileUtils;
import club.maddm.utils.TimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private IpConfiguration ipConfiguration;

    @PostMapping("uploadImg")
    public ResponseEntity<Object> uploadImg(String type,@RequestParam("file") MultipartFile file) {
        //验证文件上传type是否正确
        String typePath = "img";

        if(file.isEmpty()){//文件为空跳过
            throw new KingException();//TODO 上传文件不能为空
        }
        //单个文件不能大于10M
        if(file.getSize()>(10*1024*1024)){
            throw new KingException(ExceptionEnum.FILE_IS_TOO_LARGE);
        }
        String path = File.separator + typePath + File.separator;

        //创建文件名称
        String fileName = FileUtils.getName(file.getOriginalFilename());

        //TODO 真实环境考虑返回文件对象，其中有缩略图路径等等
        String uploadFilePath = FileUtils.localUploadFile(path, fileName, file);//使用上传工具上传

        if (StringUtils.isBlank(uploadFilePath)) {
                throw new KingException();//TODO 文件上传失败异常
        }
        ReactFileVO reactFileVO = new ReactFileVO();
//        reactFileVO.setName(file.getOriginalFilename());
//        reactFileVO.setThumbUrl(ipConfiguration.getAddress() + uploadFilePath);
//        reactFileVO.setUrl(ipConfiguration.getAddress() + uploadFilePath);
        reactFileVO.setStatus("done");//文件上传成功
//            ConferenceFile bz = new ConferenceFile();
//            if(StringUtils.isNotBlank(resolveId)){
//                bz.setResolveId(resolveId);
//            }
//            bz.setName(multipartFile.getOriginalFilename());//文件实际名称
//            bz.setDescription(path + fileName);//文件路径
//            bz.setFileSize(multipartFile.getSize());//文件大小
//            bz.setCreateTime(new Date());
//            bz.setCreateName(user.getId());
//            bz.setUnitId(user.getUnitId());
//            bz.setModelType(modelType);
//            if(StringUtils.isNotBlank(fileName)){
//                String[] str1Array = fileName.split("\\.");
//                if(str1Array.length>1){
//                    bz.setType(str1Array[str1Array.length-1]);
//                }
//            }
//            insert(bz);
//            ids.add(bz.getId());

        return ResponseEntity.ok(reactFileVO);
    }

    @PostMapping("userImg")
    public List<String> uploadFile(String type, MultipartFile[] file) {

        //验证文件上传type是否正确
        String typePath = "img";

        List<String> ids = new ArrayList<>();

        for (MultipartFile multipartFile : file) {//循环文件
            if(multipartFile.isEmpty()){//文件为空跳过
                continue;
            }
            //单个文件不能大于10M
            if(multipartFile.getSize()>(10*1024*1024)){
                throw new KingException(ExceptionEnum.FILE_IS_TOO_LARGE);
            }
            String path = File.separator + typePath + File.separator;
            //创建文件名称

            String fileName = FileUtils.getName(multipartFile.getOriginalFilename());

            boolean isTrueUpload = FileUtils.uploadFile(path, fileName,multipartFile);//使用上传工具上传

            if (!isTrueUpload) {
//                throw new BusinessException("文件上传失败");
            }
//            ConferenceFile bz = new ConferenceFile();
//            if(StringUtils.isNotBlank(resolveId)){
//                bz.setResolveId(resolveId);
//            }
//            bz.setName(multipartFile.getOriginalFilename());//文件实际名称
//            bz.setDescription(path + fileName);//文件路径
//            bz.setFileSize(multipartFile.getSize());//文件大小
//            bz.setCreateTime(new Date());
//            bz.setCreateName(user.getId());
//            bz.setUnitId(user.getUnitId());
//            bz.setModelType(modelType);
//            if(StringUtils.isNotBlank(fileName)){
//                String[] str1Array = fileName.split("\\.");
//                if(str1Array.length>1){
//                    bz.setType(str1Array[str1Array.length-1]);
//                }
//            }
//            insert(bz);
//            ids.add(bz.getId());
        }
        return ids;
    }

    @PostMapping("/upload")
    public String uplaod(@RequestParam("file") MultipartFile file,String type) {
        try {
            String filename = file.getOriginalFilename();//原文件名

            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = "";

            //3、没有文件服务其采用绝地址加是时间戳
            String destFileName = "/Users/wangyiming/uploadFile"
                    + File.separator + TimeUtils.getFileName()
                    + File.separator + fileName;

            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);

            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置

            file.transferTo(destFile);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "showImg";
    }


    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response) throws UnsupportedEncodingException {

        String destFileName = "/Users/wangyiming/uploadFile";//基础文件路径

        String filename="IMG_0525.png";
        String filePath = destFileName;

        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
//            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
             response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download---" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}