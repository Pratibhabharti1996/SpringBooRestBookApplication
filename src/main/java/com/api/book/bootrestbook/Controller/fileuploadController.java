package com.api.book.bootrestbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.FileUploadHelper;


@RestController
public class fileuploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;


    @PostMapping("/uploadFile")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file)
    {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());

        try{
        //validation
        if(file.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
        }
        if(!file.getContentType().equals("image/jpeg"))
        {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg images is allowed");
        
        }
        //file upload code..

       boolean b= fileUploadHelper.uploadfile(file);
       if(b)
       {
        //  return ResponseEntity.ok("File upload succesfully");
        // Now return the File Path for Dynamic path 
        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images").path(file.getOriginalFilename()).toUriString());
       }
    }
    catch(Exception e){
        e.printStackTrace();
    }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing went Wrong! Try somthing else");
    }
    
}
