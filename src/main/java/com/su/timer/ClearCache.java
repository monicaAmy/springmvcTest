package com.su.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * NieSu 2018/1/28
 */
@Service
public class ClearCache
{
  private static final SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("hh:mm:ss");
  public void clear()
  {
    System.out.println("emial......."+DATE_FORMAT.format(new Date()));
  }
}
