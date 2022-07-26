package com.api.book.bootrestbook.helper;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "E:\\VSCodeWorkspace\\bootrestbook\\src\\main\\resources\\static\\images";
 // HERE WHEN select path then single slash coming make it double in above line

 public boolean uploadfile(MultipartFile multipartFile)
 {
    boolean f = false;
    try{
        // InputStream is = multipartFile.getInputStream();
        // byte data[] = new byte[is.available()];
        // is.read(data);

        // //write
        // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
        // fos.write(data);
        // fos.flush();
        // fos.close();
        // fos.close();

        //alter way of above code is below in one line
        Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        f= true;

    }
    catch(Exception e){
        e.printStackTrace();
    }
    return f;
 }
    
}
