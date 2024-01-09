package com.solvd.storeDataBase.exceptions;

public class CantDeleteInexistentProductException extends Exception{
    public CantDeleteInexistentProductException(String message) {
        super(message);
    }
}
