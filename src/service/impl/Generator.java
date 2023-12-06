package service.impl;

public class Generator {
    public static long id = 0;
    public static long idUser = 0;

    public static long genera(){
        return (++id);
    }
    public static long generaUser(){
        return (++idUser);
    }
}
