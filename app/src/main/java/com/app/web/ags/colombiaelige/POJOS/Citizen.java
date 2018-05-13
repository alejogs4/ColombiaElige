package com.app.web.ags.colombiaelige.POJOS;

import android.content.ContentValues;

public class Citizen {

    private String dni;

    public Citizen(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ContentValues toValues() {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("cedula",dni);
        return contentValues;
    }
}
