/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.dao.DvdLibraryDao;
import com.mthree.dvdlibrary.dto.Dvd;
import com.mthree.dvdlibrary.ui.DvdLibraryView;
import java.util.List;

/**
 *
 * @author Chuck
 */
public class DvdLibraryController {

    private DvdLibraryView view;
    private DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        
        boolean keepGoing = true;
        int menuSelection = 0;
        
        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1 -> listDvds();
                case 2 -> createDvd();
                case 3 -> viewDvd();
                case 4 -> removeDvd();
                case 5 -> editDvd();
                case 6 -> keepGoing = false;
                default -> unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDvd() {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }
    
    private void listDvds() {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    
    private void viewDvd() {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }
    
    private void removeDvd() {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(dvdTitle);
        view.displayRemoveResult(removedDvd);
    }
    
    private void editDvd() {
        
        view.displayEditDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        
        if (dvd != null) {
            int choice = view.printEditMenuAndGetSelection(dvd);
            switch (choice) {
                case 1 -> dvd.setTitle(view.getEditTitleChoice());
                case 2 -> dvd.setReleaseDate(view.getEditDateChoice());
                case 3 -> dvd.setMpaaRating(view.getEditMpaaRatingChoice());
                case 4 -> dvd.setDirector(view.getEditDirectorChoice());
                case 5 -> dvd.setStudio(view.getEditStudioChoice());
                case 6 -> dvd.setUserRating(view.getEditUserRatingChoice());
                default -> unknownCommand();
            }

            dao.removeDvd(dvdTitle);
            dao.addDvd(dvd.getTitle(), dvd);
        }
        
        view.displayEditResult(dvd);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
