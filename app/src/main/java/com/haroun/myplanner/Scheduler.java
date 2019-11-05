/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haroun.myplanner;

import com.haroun.myplanner.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author harounchahed
 */
public class Scheduler  {
    Planner planner ;
    List<Task> todo;
    
    Scheduler(Planner planner) {
        this.planner = planner ;
    }
    
    String schedule() {
        todo = planner.getTasks() ; 
        Collections.sort(todo) ;
        String res = ""  ; 
        for (Task task: todo) { 
            res += task.display() ; 
        }
    return res ;
    }
}
