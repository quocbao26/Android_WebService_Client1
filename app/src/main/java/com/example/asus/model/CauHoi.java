package com.example.asus.model;

import java.io.Serializable;

/**
 * Created by Asus on 24/04/2018.
 */

public class CauHoi implements Serializable {
    private int MACH;
    private String NDCH;
    private String A;
    private String B;
    private String C;
    private String D;
    private String DA;

    @Override
    public String toString() {
        return MACH+" - "+NDCH+"\n"+A+" - "+B+" - "+C+" - "+D+" - "+DA;
    }

    public int getMACH() {
        return MACH;
    }

    public void setMACH(int MACH) {
        this.MACH = MACH;
    }

    public String getNDCH() {
        return NDCH;
    }

    public void setNDCH(String NDCH) {
        this.NDCH = NDCH;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getDA() {
        return DA;
    }

    public void setDA(String DA) {
        this.DA = DA;
    }
}
