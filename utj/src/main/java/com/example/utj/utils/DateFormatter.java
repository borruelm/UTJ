package com.example.utj.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public Timestamp getDate(String oldDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(oldDate.split("T", 10)[0]);
        return new Timestamp(parsedDate.getTime());
    }
}
