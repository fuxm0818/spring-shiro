package com.cattsoft.security.handler.springMVCConverter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: springMVC接收前端参数使用的转换器 <br>
 * Copyright:DATANG SOFTWARE CO.LTD<br>
 *
 * @author fuxiangming
 * @date 2018/2/1 上午10:32
 */
@Component
public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String stringDate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatShort = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (stringDate.length() > 12) {
                return format.parse(stringDate);
            } else {
                return formatShort.parse(stringDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}