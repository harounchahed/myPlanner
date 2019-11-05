/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haroun.myplanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author harounchahed
 */
public class Planner {
    String name ; 
    String descroption ; 
    
    private final ArrayList<Project> projects;
    
    Planner(String name) {
        projects = new ArrayList<>();
        this.name = name ; 
    }
    
    void addProject(Project p) {
      this.projects.add(p);
    }
    
    Iterable<Project> getProjects() {
        return projects;
    }
    
    public String toXML() {
        String boardStr = "";
        for (Project p : projects) {
            boardStr += p.toXML();
        }
        String res = "<planner>\n" + boardStr + "</planner>\n";
        return res;
    }
    
        List<Task> getTasks() {
        ArrayList res = new ArrayList();
        for (Project p : this.getProjects()) {
            for (Section s : p.getSections()) {
                for (Task t : s.getTasks()) {
                    res.add(t);
                }
            }
        }
        return res;
    }
    
    private static Date getInDays(long days) {
        return new Date(Calendar.getInstance().getTime().getTime() + Duration.ofDays(days).toMillis());
    }

    /*
    public static Planner demo () { 
        Planner myPlanner = new Planner("my Planner") ; 
        
        com.mycompany.planner.Project seniorYear = new com.mycompany.planner.Project("Senior Year Plan") ;
        com.mycompany.planner.Project jobApplications = new com.mycompany.planner.Project("Job Applications for senior year") ;
        
        com.mycompany.planner.Section machineLearning = new com.mycompany.planner.Section("Machine Learning") ;
        com.mycompany.planner.Section softwareEngineering = new com.mycompany.planner.Section("Softare engineering") ;
        com.mycompany.planner.Section programmingDS = new com.mycompany.planner.Section("Programming for Data Science") ;
        com.mycompany.planner.Section capstone = new com.mycompany.planner.Section("Capstone") ;
        
        com.mycompany.planner.Section OW = new com.mycompany.planner.Section("job Application to Oliver Wyman") ;
        com.mycompany.planner.Section SAP = new com.mycompany.planner.Section("Job Application to SAP") ;
        
        com.mycompany.planner.Task assignment = new com.mycompany.planner.Task("Do Assignment", getInDays(0) , Duration.ofDays(1) , getInDays(20)) ;
        com.mycompany.planner.Task revise = new com.mycompany.planner.Task("Study for exam", getInDays(1) , Duration.ofDays(2) , getInDays(20)) ;
        com.mycompany.planner.Task read = new com.mycompany.planner.Task("Do readings", getInDays(1) , Duration.ofDays(1) , getInDays(15));
        com.mycompany.planner.Task quiz = new com.mycompany.planner.Task("Do online quiz", getInDays(0) , Duration.ofDays(3) , getInDays(40)) ;
        com.mycompany.planner.Task research = new com.mycompany.planner.Task("Research topic", getInDays(2) , Duration.ofDays(2) , getInDays(20)) ;
        
        com.mycompany.planner.Task letter = new com.mycompany.planner.Task("Write Cover Letter", getInDays(1) , Duration.ofDays(2) , getInDays(10)) ;
        com.mycompany.planner.Task interview = new com.mycompany.planner.Task("Prepare for internview", getInDays(1) , Duration.ofDays(1) , getInDays(5)) ;
        com.mycompany.planner.Task submit = new com.mycompany.planner.Task("Submit Application", getInDays(1) , Duration.ofDays(1) , getInDays(20)) ;
        com.mycompany.planner.Task resume = new com.mycompany.planner.Task("Edit resume", getInDays(2) , Duration.ofDays(3) , getInDays(20));
        
        myPlanner.addProject(seniorYear) ; 
        myPlanner.addProject(jobApplications) ; 
        
        seniorYear.addSection(machineLearning) ;
        seniorYear.addSection(softwareEngineering) ;
        seniorYear.addSection(programmingDS) ;
        seniorYear.addSection(capstone) ;
        
        jobApplications.addSection(OW); 
        jobApplications.addSection(SAP);
        
        machineLearning.addTask(quiz);
        machineLearning.addTask(revise);
        capstone.addTask(assignment); 
        capstone.addTask(research) ; 
        programmingDS.addTask(read); 
        programmingDS.addTask(assignment); 
        softwareEngineering.addTask(quiz);
        
        OW.addTask(letter);
        OW.addTask(interview); 
        SAP.addTask(resume);
        SAP.addTask(submit);
        
        return myPlanner; 
    }
    */

    void saveXMLFile(String filename) {
        String str = this.toXML();
          try {
              Files.write(Paths.get(filename), str.getBytes());
          } catch (IOException ex) {
              Logger.getLogger(Planner.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
 
    static void readXMLFile(String filename) throws ParserConfigurationException, SAXException, IOException {
        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build Document        
        FileInputStream fis = new FileInputStream("/Users/harounchahed/NetBeansProjects/Planner/demo.xml");
        InputSource is = new InputSource(fis);
        Document document = builder.parse(is);

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        //Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        //Get projects
        NodeList nList = document.getElementsByTagName("project");
        System.out.println("============================");
        for (int temp = 0; temp < nList.getLength(); temp++)
            {
            Node node = nList.item(temp);
            System.out.println("");    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
               //Print each project's detail
               Element eElement = (Element) node;
               System.out.println("Project : "  + eElement.getElementsByTagName("project").item(0).getTextContent());
               System.out.println("Section : "   + eElement.getElementsByTagName("section").item(0).getTextContent());
               System.out.println("Task : "    + eElement.getElementsByTagName("task").item(0).getTextContent());
            }
            }

    }
}
