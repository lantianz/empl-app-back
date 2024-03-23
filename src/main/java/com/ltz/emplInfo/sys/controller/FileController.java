package com.ltz.emplInfo.sys.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.ltz.emplInfo.common.vo.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private static final String filePath = System.getProperty("user.dir") + "/file/";

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {
        synchronized (FileController.class) {
            // flag获取到时间戳
            String flag = System.currentTimeMillis() + "";
            String fileName = file.getOriginalFilename();
            try {
                // 没有目录则创建
                if (!FileUtil.isDirectory(filePath)) {
                    FileUtil.mkdir(filePath);
                }
                // 文件存储形式：时间戳-文件名
                FileUtil.writeBytes(file.getBytes(), filePath + flag + "-" + fileName);
                System.out.println(fileName + "上传成功");
                Thread.sleep(1L);
            } catch (Exception e) {
                System.out.println(fileName + "上传失败");
            }
            return Result.success(flag, "上传成功");
        }
    }

    // 获取文件
    @GetMapping("/download/{flag}")
    public void filePath(@PathVariable String flag, HttpServletResponse response) {
        if (!FileUtil.isDirectory(filePath)) {
            FileUtil.mkdir(filePath);
        }
        OutputStream os;
        List<String> fileNames = FileUtil.listFileNames(filePath);
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(filePath + fileName);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (IOException e) {
            System.out.println("文件下载失败" + e.getMessage());
        }
    }

    @PostMapping("/wang/upload")
    public Map<String, Object> editorUpload(MultipartFile file) {
        String flag = System.currentTimeMillis() + "";
        String fileName = file.getOriginalFilename();
        try {
            // 文件存储形式：时间戳-文件名
            FileUtil.writeBytes(file.getBytes(), filePath + flag + "-" + fileName);
            System.out.println(fileName + "上传成功");
            Thread.sleep(1L);
        } catch (Exception e) {
            System.out.println(fileName + "上传失败");
        }
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("errno", 0);
        resMap.put("data", CollUtil.newArrayList(Dict.create()
                .set("url", "http://10.0.0.168:8888/api/files/download/" + flag)
                .set("href", "http://10.0.0.168:8888/api/files/download/" + flag)
        ));
        return resMap;
    }
}
