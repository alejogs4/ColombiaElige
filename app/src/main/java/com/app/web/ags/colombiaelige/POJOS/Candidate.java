package com.app.web.ags.colombiaelige.POJOS;

import android.content.ContentValues;

public class Candidate {

    private String dni;
    private String name;
    private String lastname;
    private String politic_party;
    private String imageUrl;

    public Candidate(String dni, String name, String lastname, String politic_party, String imageUrl) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.politic_party = politic_party;
        this.imageUrl = imageUrl;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPolitic_party() {
        return politic_party;
    }

    public void setPolitic_party(String politic_party) {
        this.politic_party = politic_party;
    }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }


    public ContentValues toValues() {
        ContentValues contentValues = new ContentValues(6);
        contentValues.put("dni",dni);
        contentValues.put("name",name);
        contentValues.put("lastname",lastname);
        contentValues.put("politic_party",politic_party);
        contentValues.put("image",imageUrl);
        return contentValues;
    }
}
