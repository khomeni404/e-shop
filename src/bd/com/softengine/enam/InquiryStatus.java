package com.ibbl.report.util;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Copyright (C) 2002-2003 Islami Bank Bangladesh Limited
 * <p/>
 * Original author: Khomeni
 * Date: 03/01/2016
 * Last modification by: ayat $
 * Last modification on 03/01/2016: 10:33 AM
 * Current revision: : 1.1.1.1
 * <p/>
 * Revision History:
 * ------------------
 */
public enum InquiryStatus {
    REQUESTED(11, "Requested", "Inquiry has been sent to Br. Concern for approving"),
    DISPATCHED(12, "Dispatched", "Inquiry has been approved and Dispatched to CIB, Head Office."),
    PROCESSING(13, "Processing", "Inquiry is being Processed by CIB, Head Office."),
    REPORTED(14, "Reported", "Reported & Document Uploaded by CIB, Head Office."),
    COMPLAINED(15, "Complained", "Complained on inquiry");

    public static void main(String[] args) {
        System.out.println(InquiryStatus.init(15).HISTORY);
    }

/*    public static int getIndex(InquiryStatus status) {
        return status.CODE;
    }
    public static String getStatus(InquiryStatus status) {
        return status.STATUS;
    }
    public static String getHistory(InquiryStatus status) {
        return status.HISTORY;
    }*/

    public static List<InquiryStatus> getList() {
        return new ArrayList<InquiryStatus>(EnumSet.allOf(InquiryStatus.class));

    }

    /*public static String getStatus(int index) {
        String status = "---";
        List<InquiryStatus> somethingList = getList();
        for (InquiryStatus E : somethingList) {
            if (index == E.CODE) {
                status = E.STATUS;
                break;
            }
        }
        return status;
    }
    public static String getHistory(int index) {
        String hist = "---";
        List<InquiryStatus> somethingList = getList();
        for (InquiryStatus E : somethingList) {
            if (index == E.CODE) {
                hist = E.HISTORY;
                break;
            }
        }
        return hist;
    }*/

    public static InquiryStatus init(int index) {
        InquiryStatus inqStatus = null;
        List<InquiryStatus> somethingList = getList();
        for (InquiryStatus E : somethingList) {
            if (index == E.CODE) {
                inqStatus = E;
                break;
            }
        }
        return inqStatus;
    }



    public final int CODE;
    public final String STATUS;
    public final String HISTORY;

    InquiryStatus(int code, String status, String history) {
        this.CODE = code;
        this.STATUS = status;
        this.HISTORY = history;
    }


   /* public boolean equalsIndex(String otherIndex) {
        return (otherIndex == null) ? false : index.equals(otherIndex);
    }
    public boolean equalsMessage(String msg) {
        return (msg == null) ? false : history.equals(msg);
    }

    public String toString() {
        return this.index;
    }

*/
}
