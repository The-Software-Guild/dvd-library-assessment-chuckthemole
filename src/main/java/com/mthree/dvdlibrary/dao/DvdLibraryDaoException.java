
package com.mthree.dvdlibrary.dao;

/**
 *@author Charles Thomas
 *email: chuckthemole@gmail.com
 *date: 07/29/2021
 *purpose: Application for DVD Collection
 */

public class DvdLibraryDaoException extends Exception {
    public DvdLibraryDaoException(String message) {
        super(message);
    }
    
    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
