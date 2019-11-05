package com.haroun.myplanner;

import org.junit.Test;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;


public class Tasktest {
    @Test
    public void constructorCorrect() {
        Task t = new Task("Submit Application", getInDays(1) , Duration.ofDays(1) , getInDays(20)) ;
        assertEquals(t.getName(), "Submit Application");
    }


    private static Date getInDays(long days) {
        return new Date(Calendar.getInstance().getTime().getTime() + Duration.ofDays(days).toMillis());
    }
}
