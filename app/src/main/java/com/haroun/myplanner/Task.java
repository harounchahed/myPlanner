/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haroun.myplanner;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author harounchahed
 */
public class Task implements Comparable<Task>{
    int taskId; 
    String name ; 
    String description; 
    String [] tags ; 
    int estimatedDuration;
    static int numberOfTasks ; 
    private final Date     start;
    private final Duration duration;
    private final Date     deadline;
     
    Task(String name, Date start, Duration duration, Date deadline) { 
        this.name = name ;
        this.numberOfTasks =+ 1 ; 
        this.taskId = numberOfTasks ; 
        this.start = start ; 
        this.duration = duration ; 
        this.deadline = deadline ; 
    }
    
    void changeName(String name) {
        this.name = name; 
    } 
   
    
    String getName() {
        return this.name;
    }
  
    
    Date getdeadline() { 
        return this.deadline ; 
    }
    
    Date getStare() { 
        return this.start ; 
    }
    
    Duration getDuration() { 
        return this.duration ; 
    }
    
    void setDescription(String description) { 
        this.description = description ; 
    }
    
    String display () {
        return "'" + this.name + "' is scheduled for the " + this.start + " and is due on " + this.deadline + " .You have " + this.duration + " to complete it.\n" ;
    }
/*
** how to add dinamically to tags list

    
    void tag(String[] tag) { 
        this.tags tag; 
    }
*/     
    void setEstimatedDuration (int duration) {
        this.estimatedDuration = duration ; 
    }    
    
    public String toXML () { 
        String res =  "           <task name='" + this.name + "'>"  + 
                    "\n           </task>\n"; 
        return res ; 
    }

    private static Date getInDays(long days) {
        return new Date(Calendar.getInstance().getTime().getTime() + Duration.ofDays(days).toMillis());
    }

    @Override
    public int compareTo(Task o) {
    return this.getdeadline().compareTo(o.getdeadline());
  }
}