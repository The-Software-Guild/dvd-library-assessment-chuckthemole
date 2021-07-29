package com.mthree.dvdlibrary;

import com.mthree.dvdlibrary.controller.DvdLibraryController;
import com.mthree.dvdlibrary.dao.DvdLibraryDao;
import com.mthree.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mthree.dvdlibrary.ui.DvdLibraryView;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chuck
 */
public class App {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        myDao.addDvdsFromFile("dvds.txt");
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();
        myDao.writeDvdsToFile("dvds.txt");
    }
}
