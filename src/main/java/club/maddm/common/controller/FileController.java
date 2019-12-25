package club.maddm.common.controller;


import club.maddm.common.entity.vo.ReactFileVO;
import club.maddm.common.service.IBaseUploadService;
import club.maddm.common.service.IFileService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件表  前端控制器
 * </p>
 *
 * @author king
 * @since 2019-12-18
 */
@RestController
@RequestMapping("/common/file")
public class FileController {

    @Autowired
    private IFileService fileService;

    @PostMapping("uploadAvatar")
    public ResponseEntity<ReactFileVO> uploadAvatar(String type, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(fileService.uploadAvatar(file,type));
    }
}

