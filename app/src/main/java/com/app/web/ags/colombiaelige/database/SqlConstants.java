package com.app.web.ags.colombiaelige.database;

public class SqlConstants {

    public static final String DATABASE_NAME = "votacionescolombia";

    /** Tables **/
    public static final String VOTERS_TABLE = "CREATE TABLE voters (" +
            "cedula text primary key)";

    public static final String CANDIDATES_TABLE = "CREATE TABLE candidates (" +
            "dni text primary key," +
            "name text NOT NULL," +
            "lastname text NOT NULL," +
            "politic_party text NOT NULL," +
            "image text NOT NULL," +
            "type text NOT NULL)";

    public static final String VOTES_TABLE = "CREATE TABLE votes (" +
            "id integer primary key autoincrement," +
            "dni text," +
            "cedula text," +
            "type text NOT NULL," +
            "FOREIGN KEY(dni) REFERENCES candidates(dni)," +
            "FOREIGN KEY(cedula) REFERENCES voters(cedula)" +
            ")";


    public static final String DROP_DATABASE = "DROP DATABASE " + DATABASE_NAME ;
}
