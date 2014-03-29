package utils;

/**
 * User: Tom De Dobbeleer
 * Date: 2/12/14
 * Time: 1:06 AM
 * Remarks: none
 */
public class Constants {
    private Constants() {}
    public static final String CONTACTTYPE_EMAIL = "email";
    public static final String CONTACTTYPE_PHONE = "phone";

    public static final String SEARCH_TYPE_ID = "id";
    public static final String SEARCH_TYPE_NAME = "name";

    public static final String RESULT_NO_RESULTS = "Geen resultaten gevonden";
    public static final String RESULT_CLIENT_ADDED = "Klant succesvol toegevoegd";
    public static final String RESULT_SC_ADDED = "Service oproep succesvol toegevoegd";
    public static final String RESULT_SC_CHANGED = "Service oproep succesvol gewijzigd";

    public  static final String RESULT_UNKNOWN_ERROR = "Er is een onbekende fout opgetreden";
    public  static final String RESULT_ID_NOT_SPECIFIED = "Er is geen klantendId gevonden";

    public static final String LANDING_REGISTER_SERVICECALL = "jsp/registerServiceCall.jsp";
    public static final String LANDING_CLIENT_OVERVIEW = "jsp/clientOverview.jsp";
    public static final String LANDING_GENERAL_ERROR_PAGE = "jsp/error.jsp";
    public static final String LANDING_REGISTER_CLIENT = "jsp/registerClient.jsp";
    public static final String SC_XML_RESULT = "jsp/serviceCallXml.jsp";
}
