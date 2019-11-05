/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haroun.myplanner;
import java.util.ArrayList;

/**
 *
 * @author harounchahed
 */
public class Project {
    String name; 
    String description; 
    
    private final ArrayList<Section> sections ; 

    Project (String name) { 
        this.name = name ; 
        this.sections = new ArrayList<>() ; 
    }

    void changeName(String name) {
        this.name = name; 
    } 
    
    void setDescription(String description) { 
            this.description = description ; 
    }
    
    void addSection(Section section) { 
        this.sections.add(section) ; 
    }
    
    Iterable<Section> getSections() { 
        return this.sections ; 
    }
    
    
    public String toXML() {
        String projectStr = "" ; 
        for (Section s : sections) { 
            projectStr += s.toXML() ; 
        }
        return "    <project name='" + this.name + "'>\n" 
               + projectStr + 
               "    </project>\n"; 
    }
 
}
