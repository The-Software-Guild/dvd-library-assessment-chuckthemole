
package com.mthree.dvdlibrary.dao;

import com.mthree.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *@author Charles Thomas
 *email: chuckthemole@gmail.com
 *date: 07/29/2021
 *purpose: Application for DVD Collection
 */

public interface DvdLibraryDao {
    
     /**
     * Adds the given Dvds to the collection from a file. 
     *
     * @param file file where dvds are located
     * @return true if the file exists and false if the file does not exist
     */
    boolean addDvdsFromFile(String file);
    
     /**
     * Writes the Dvds to the collection file. 
     *
     * @param file file where to write the dvds
     * @return true if the file exists and false if the file does not exist
     */
    boolean writeDvdsToFile(String file);
    
    /**
     * Adds the given Dvd to the collection and associates it with the given
     * dvd title. If there is already a dvd associated with the given
     * title it will return that dvd object, otherwise it will
     * return null.
     *
     * @param dvdTitle id with which dvd is to be associated
     * @param dvd dvd to be added to the collection
     * @return the Dvd object previously associated with the given  
     * dvd title if it exists, null otherwise
     */
    Dvd addDvd(String dvdTitle, Dvd dvd);

    /**
     * Returns a List of all dvds in the collection.
     *
     * @return List containing all dvds in the collection.
     */
    List<Dvd> getAllDvds();

    /**
     * Returns the dvd object associated with the given dvd title.
     * Returns null if no such dvd exists
     *
     * @param dvdTitle title of the dvd to retrieve
     * @return the Dvd object associated with the given dvd title,  
     * null if no such dvd exists
     */
    Dvd getDvd(String dvdTitle);

    /**
     * Removes the dvd associated with the given title.
     * Returns the dvd object that is being removed or null if
     * there is no dvd associated with the given title
     *
     * @param dvdTitle title of dvd to be removed
     * @return Dvd object that was removed or null if no dvd
     * was associated with the given dvd title
     */
    Dvd removeDvd(String dvdTitle);
    
    /**
     * Edits the dvd associated with the given title.
     * Returns the dvd object that is being edited or null if
     * there is no dvd associated with the given title
     *
     * @param dvdTitle title of dvd to be edited
     * @return Dvd object that was edited or null if no dvd
     * was associated with the given dvd title
     */
    Dvd editDvd(String dvdTitle);
}
