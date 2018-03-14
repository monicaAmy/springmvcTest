package com.su.uploadfile;

import org.springframework.web.multipart.MultipartFile;

/**
 * NieSu 2018/3/14
 */
public class BIFile
{
  private String name;
  private Integer size;
  private MultipartFile file;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Integer getSize()
  {
    return size;
  }

  public void setSize(Integer size)
  {
    this.size = size;
  }

  public MultipartFile getFile()
  {
    return file;
  }

  public void setFile(MultipartFile file)
  {
    this.file = file;
  }
}
