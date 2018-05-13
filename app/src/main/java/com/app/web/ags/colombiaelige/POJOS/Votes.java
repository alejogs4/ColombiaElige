package com.app.web.ags.colombiaelige.POJOS;

import android.content.ContentValues;

public class Votes {

    private String dni;
    private String colombianDni;

    public Votes(String dni, String colombianDni) {
        this.dni = dni;
        this.colombianDni = colombianDni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getColombianDni() {
        return colombianDni;
    }

    public void setColombianDni(String colombianDni) {
        this.colombianDni = colombianDni;
    }

    public ContentValues toValues() {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("dni", dni);
        contentValues.put("cedula", colombianDni);
        return contentValues;
    }
}
