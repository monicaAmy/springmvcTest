package com.su.uploadfile;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * NieSu 2018/3/14
 */
@Controller
public class UpLoadFileController
{

  @RequestMapping("/upload")
  public @ResponseBody BIResp upload(@ModelAttribute BIFile biFile)
  {
    BIResp biResp = new BIResp();
    try
    {
      System.out.println("name ==="+biFile.getName());
      System.out.println("size ==="+biFile.getSize());
      MultipartFile file = biFile.getFile();
      if(file==null)
      {
        System.out.println("null----------------------");
        biResp.setCode(-1);
        biResp.setDesc("failed");
       // return JSONObject.toJSONString(biResp);
        return biResp;
      }
      File file1 = new File("G:\\mtk\\");
      System.out.println(file1);
      String originalFilename = file.getOriginalFilename();
      System.out.println("originalFilename :"+originalFilename);
      String suffix=originalFilename.substring(originalFilename.lastIndexOf(".")+1, originalFilename.length());
      String contentType = file.getContentType();
      System.out.println("contentType : "+contentType);
      file.transferTo(new File("G:\\mtk\\ee."+suffix));
    }
    catch (IOException e)
    {
      biResp.setCode(-1);
      biResp.setDesc("failed");
      e.printStackTrace();
      //return JSONObject.toJSONString(biResp);
      return biResp;
    }
    biResp.setCode(0);
    biResp.setDesc("success");
    //return JSONObject.toJSONString(biResp);
    return biResp;
  }



}
