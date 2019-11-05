/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haroun.myplanner;
import com.haroun.myplanner.Task;

import java.util.ArrayList;

/**
 *
 * @author harounchahed
 */
public class Section {
    String name; 
    String description;   

    private final ArrayList<Task> tasks ;
    
    Section (String name) { 
        this.name = name ; 
        this.tasks = new ArrayList<>() ; 
    }

    void changeName(String name) {
        this.name = name; 
    } 
    
    void setDescription(String description) { 
            this.description = description ; 
    }
    
    void addTask(Task task) { 
        this.tasks.add(task) ;
    }

    Iterable<Task> getTasks() {
        return tasks;
    }
    
    public String toXML() {
        String sectionStr = "" ; 
        for (Task t : tasks) { 
            sectionStr += t.toXML() ; 
        }
        return "        <section name='" + this.name + "'>\n" 
               + sectionStr + 
               "        </section>\n"; 
    }
}


        
