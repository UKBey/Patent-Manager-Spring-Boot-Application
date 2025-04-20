package com.patentmanager.PatentManager.exception;

public class ErrorMessage {
    public static final String ERROR_AUTHOR_NOT_FOUND = "Author not found.";
    public static final String ERROR_PATENT_NOT_FOUND = "Patent not found.";
    public static final String ERROR_CERTIFICATION_NOT_FOUND = "Certification not found.";

    public static final String ERROR_INVALID_AUTHOR_DATA = "Invalid or incomplete author data.";
    public static final String ERROR_INVALID_PATENT_DATA = "Invalid or incomplete patent data.";
    public static final String ERROR_INVALID_CERTIFICATION_DATA = "Invalid or incomplete certification data.";

    public static final String ERROR_AUTHOR_DELETION_NOT_ALLOWED = "This author is linked to a certification and cannot be deleted.";
    public static final String ERROR_PATENT_DELETION_NOT_ALLOWED = "This patent is linked to a certification and cannot be deleted.";
}