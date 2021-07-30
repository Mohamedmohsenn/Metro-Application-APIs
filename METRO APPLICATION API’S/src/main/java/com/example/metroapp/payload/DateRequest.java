package com.example.metroapp.payload;

import java.util.Date;

public class DateRequest {
   private Date newDate;

   public DateRequest()
   {

   }

    public DateRequest(Date newDate) {
        this.newDate = newDate;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }
}
