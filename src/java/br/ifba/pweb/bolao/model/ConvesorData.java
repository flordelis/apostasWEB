/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author lisy
 */
public class ConvesorData {
    
    public static Calendar DateToCalendar(Date date ) 
{ 
 Calendar cal = null;
 try {   
  DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
  date = (Date)formatter.parse(date.toString()); 
  cal=Calendar.getInstance();
  cal.setTime(date);
  }
  catch (ParseException e)
  {
      System.out.println("Exception :"+e);  
  }  
  return cal;
 }
    
}
