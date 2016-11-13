/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.com.softengine.util;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khomeni
 */
public class StringUtil {

    public static String validateCellNo(String cellPhone) {
        cellPhone = cellPhone.trim();
        cellPhone = cellPhone.replaceAll("[^\\d]", "");
        return cellPhone;
    }
    
    public static String nullToZeroLengthStr(String string) {
	if(string == null) {
	    string = "";
	}

	return string;
    }
    
    public static double roundToDecimals(double d, int c) {
	int temp = (int) ((d * Math.pow(10, c)));
	double returndouble = (((double) temp) / Math.pow(10, c));
        
	return returndouble;
    }
    
    public static String stringEsc(String in) {
	if(in == null)
	    return "";
	if(in.compareToIgnoreCase("null") == 0)
	    return "";
        
	return in;
    }
    
    /**
     * Serialize a map of string
     * 
     * @param mapOfStrings
     * @param separator
     * @param terminator
     * @return string
     */
    public static String serializeMapOfStrings(Map<String, String> mapOfStrings, String separator,
	    String terminator) {

	StringBuffer buff = null;

	if(mapOfStrings != null) {
	    buff = new StringBuffer();

	    if(mapOfStrings.keySet() != null && mapOfStrings.keySet().size() > 0) {
		Iterator<String> keyIt = mapOfStrings.keySet().iterator();

		while(keyIt.hasNext()) {
		    buff.append(mapOfStrings.get(keyIt.next()));

		    if(keyIt.hasNext()) {
			buff.append(separator);
		    } else {
			buff.append(terminator);
		    }
		}
	    }
	}

	String returnString = buff.toString();
        
	return returnString;
    }
    
    /**
     * Serialize a List Of String
     * 
     * @param listOfStrings
     * @return String
     */
    public static String serializeListOfString(List<String> listOfStrings) {
	return serializeListOfString(listOfStrings, "");
    }
    
     /**
     * Serialize a List Of String
     * 
     * @param listOfStrings
     * @param separator
     * @return String
     */
    public static String serializeListOfString(List<String> listOfStrings, String separator) {
	return serializeListOfString(listOfStrings, separator, "");
    }
    
    /**
     * Serialize a List Of String
     * 
     * @param listOfStrings
     * @param separator
     * @param terminator
     * @return String
     */
    public static String serializeListOfString(List<String> listOfStrings, String separator,
	    String terminator) {

	StringBuffer serializedStrBuff = null;

	if(listOfStrings != null) {
	    serializedStrBuff = new StringBuffer();

	    if(listOfStrings.size() > 0) {
		Iterator<String> listIt = listOfStrings.iterator();

		while(listIt.hasNext()) {
		    serializedStrBuff.append(listIt.next());

		    if(listIt.hasNext()) {
			serializedStrBuff.append(separator);
		    } else {
			serializedStrBuff.append(terminator);
		    }
		}
	    }
	}

	String returnString = serializedStrBuff.toString();
        
	return returnString;
    }
    
    /**
     * De-serialize a List Of String
     * 
     * @param listOfString
     * @param separator
     * @param terminator
     * @return List
     */
    public static List<String> deserializeListOfString(String listOfString, String separator,
	    String terminator) {

	List<String> listOfStrings = null;

	if(listOfString != null && listOfString.length() > 0) {
	    listOfStrings = new ArrayList<String>();
	    String[] tokens = listOfString.split(separator);

	    for(String token : tokens) {

		if(token.equals(terminator)) {
		    break;
		} else {
		    listOfStrings.add(token);
		}
	    }
	}
        
	return listOfStrings;
    }
    
     /**
     * Serialize a List Of String
     * 
     * @param listOfListOfString
     * @param separator
     * @param terminator
     * @return string
     */
    public static String serializeListOfListOfString(List<List<String>> listOfListOfString,
	    String separator, String terminator) {

	StringBuffer buff = null;

	if(listOfListOfString != null) {
	    buff = new StringBuffer();

	    if(listOfListOfString.size() > 0) {
		Iterator<List<String>> llosIt = listOfListOfString.iterator();

		while(llosIt.hasNext()) {
		    buff.append(StringUtil.serializeListOfString(llosIt.next(), separator,
			    terminator));
		}
	    }
	}

	String returnString = buff.toString();
        
	return returnString;
    }
    
    /**
     * Retrieve a string from a html element
     * 
     * @param e
     * @return
     */
    public static String getCharacterDataFromElement(Element e) {

	if(e == null)
	    return "";
	Node child = e.getFirstChild();

	if(child instanceof CharacterData) {
	    CharacterData cd = (CharacterData) child;
	    String returnString = cd.getData();
            
	    return returnString;
	}

	return "";
    }
}
