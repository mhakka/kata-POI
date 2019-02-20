package com.mha.poi.utils;

public class TechnicalException extends Exception {

    public TechnicalException() {
    }

    public TechnicalException(String string) {
        super(string);
    }

    public TechnicalException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public TechnicalException(Throwable thrwbl) {
        super(thrwbl);
    }

    public TechnicalException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
