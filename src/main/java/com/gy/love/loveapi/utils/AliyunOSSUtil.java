package com.gy.love.loveapi.utils;

import com.aliyun.oss.OSSClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class AliyunOSSUtil {
    private String endpoint = "oss-cn-beijing.aliyuncs.com";
    private String accessKeyId = "LTAIFEu1lB27Z1nz";
    private String accessKeySecret = "mdw1dL4G4FQUskqnInbkOmPFOVj1yA";
    private OSSClient ossClient;

    public AliyunOSSUtil(){
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    public void init(){
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     *
     * @param file 上传的文件
     * @param rootName  文件名
     * @return
     * @throws IOException
     */
    public String uploadFile(MultipartFile file, String rootName) throws IOException{
        if (file.getSize() > 100 * 1024 * 1024) {
            return null;
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        String name = UUID.randomUUID()+ substring;
        InputStream inputStream = file.getInputStream();

        ossClient.putObject("love-api-1",rootName+"/"+name,inputStream);

        ossClient.shutdown();

        return name;
    }

    /**
     * 上传新图片,删除原图片,用于更新.
     * 先上传,再删除.
     * @param file		图片文件
     * @param rootName	存放路径
     * @param oldName	旧图片名称
     * @return	新图片名字
     * @throws IOException
     * 2017年11月27日 下午6:57:01
     * @author 李燃
     */
    public String uploadFile(MultipartFile file, String rootName, String oldName)throws IOException {
        String name=uploadFile(file, rootName);

        init();
        ossClient.deleteObject("love-api-1", oldName);
        ossClient.shutdown();
        return name;
    }

}
