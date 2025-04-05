package com.example.bdejemplo.model;

public class Constantes {

    public static String NAME_BD = "pruebabd";
    public static int NAME_VERSION = 14;

    public static String SENTECIACIUDAD =
            "CREATE TABLE Ciudad (" +
                    "cod INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT)";

    public static String CREARDATOS =
            "CREATE TABLE Datos (" +
                    "cod INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT, " +
                    "apellido TEXT, " +
                    "direccion TEXT, " +
                    "cod_ciudad INTEGER)";

    public static String CREARBARRIO =
            "CREATE TABLE Barrio (" +
                    "cod INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT NOT NULL)";
}
