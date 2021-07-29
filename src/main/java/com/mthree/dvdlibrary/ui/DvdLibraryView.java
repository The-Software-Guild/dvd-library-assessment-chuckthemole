/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.dvdlibrary.ui;

import com.mthree.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author Chuck
 */
public class DvdLibraryView {
    
    private UserIO io;
    
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Dvds");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public int printEditMenuAndGetSelection(Dvd dvd) {
        io.print("Edit DVD Menu");
        io.print("1. Edit Title");
        io.print("2. Edit Release Date");
        io.print("3. Edit MPAA Rating");
        io.print("4. Edit Director");
        io.print("5. Edit Studio");
        io.print("6. Edit User Rating");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public String getEditTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }
    
    public String getEditDateChoice() {
        return io.readString("Please enter the DVD Date.");
    }
    
    public String getEditMpaaRatingChoice() {
        return io.readString("Please enter the DVD MPAA Rating.");
    }
    
    public String getEditDirectorChoice() {
        return io.readString("Please enter the DVD Director.");
    }
    
    public String getEditStudioChoice() {
        return io.readString("Please enter the DVD Studio.");
    }
    
    public String getEditUserRatingChoice() {
        return io.readString("Please enter the DVD User Rating.");
    }

    public Dvd getNewDvdInfo() {
        String dvdTitle = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter a Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String director = io.readString("Please enter the Director");
        String studio = io.readString("Please enter the Studio");
        String userRating = io.readString("Please enter the user rating");
        Dvd currentDvd = new Dvd(dvdTitle);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirector(director);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }
    
    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format("* %s \n  Rating: %s \n  Director: %s\n",
                  currentDvd.getTitle(),
                  currentDvd.getMpaaRating(),
                  currentDvd.getDirector());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayDvdBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }
    
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("  " + dvd.getTitle());
            io.print("  " + dvd.getMpaaRating());
            io.print("  " + dvd.getDirector());
            io.print("  " + dvd.getStudio());
            io.print("  " + dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDvdBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(Dvd dvd) {
        if(dvd != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayEditDvdBanner () {
        io.print("=== Edit DVD ===");
    }
    
    public void displayEditResult(Dvd dvd) {
        if(dvd != null){
            io.print("DVD successfully edited.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
}
