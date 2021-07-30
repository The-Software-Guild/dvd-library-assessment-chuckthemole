
package com.mthree.dvdlibrary.dao;

import com.mthree.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *@author Charles Thomas
 *email: chuckthemole@gmail.com
 *date: 07/29/2021
 *purpose: Application for DVD Collection
 */

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String dvdTitle, Dvd dvd) {
        Dvd prevDvd = dvds.put(dvdTitle, dvd);
        return prevDvd; 
    }

    @Override
    public List<Dvd> getAllDvds() {
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String dvdTitle) {
        return dvds.get(dvdTitle);
    }

    @Override
    public Dvd removeDvd(String dvdTitle) {
        Dvd removedDvd = dvds.remove(dvdTitle);
        return removedDvd;
    }

    @Override
    public boolean addDvdsFromFile(String file) {

        Scanner sc;
        
        try {
            sc = new Scanner(new BufferedReader(new FileReader(file)));
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] dvdData = currentLine.split("::");
                for (int i = 0; i < dvdData.length; i++) {
                    StringBuilder sb = new StringBuilder(dvdData[i]);
                    sb.replace(sb.indexOf("<"), sb.indexOf("<") + 1, "");  
                    sb.replace(sb.indexOf(">"), sb.indexOf(">") + 1, "");
                    dvdData[i] = sb.toString();
                }
                Dvd dvd = new Dvd(dvdData[0], dvdData[1], dvdData[2], dvdData[3], dvdData[4], dvdData[5]);
                addDvd(dvdData[0], dvd);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DvdLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }

    @Override
    public boolean writeDvdsToFile(String file) { 

        try {
            PrintWriter out = new PrintWriter(new FileWriter(file));
            for (Dvd dvd : dvds.values()) {
                out.println("<" + dvd.getTitle() + ">::" + 
                        "<" + dvd.getReleaseDate() + ">::" +
                        "<" + dvd.getMpaaRating() + ">::" +
                        "<" + dvd.getDirector() + ">::" +
                        "<" + dvd.getStudio() + ">::" +
                        "<" + dvd.getUserRating() + ">");
            }
            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(DvdLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    @Override
    public Dvd editDvd(String dvdTitle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
