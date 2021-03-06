package org.eol.validator.functions;

import org.eol.handlers.DwcaHandler;
import org.eol.validator.ArchiveFileState;
import org.eol.validator.TermURIs;
import org.gbif.dwca.io.ArchiveFile;

import java.util.ArrayList;

/**
 * Functions populated in ValidationRules.xml using ValidationFunctions.java
 * 1. Check whether identifier exists or not
 */

public class ReferenceValidationFunctions {
    public static final String ROW_TYPE = "http://eol.org/schema/reference/Reference";
    public static ArrayList<String> failedReferences = new ArrayList<String>();
    /**
     * Checking if any of the following fields exist:
     * http://eol.org/schema/reference/
     * http://eol.org/schema/reference/primaryTitle
     * http://purl.org/dc/terms/title'
     *
     * @param archiveFile
     * @return
     */
    public static ArchiveFileState checkReferencesHasTitles_RowValidator(ArchiveFile archiveFile) {
        String[] termsString = {TermURIs.referenceURI, TermURIs.primaryTitleURI, TermURIs.titleURI};
        return DwcaHandler.checkRecordsHaveAtLeastOneOfTermsList(archiveFile, termsString, TermURIs.referenceURI);
    }

}
