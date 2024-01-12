package com.solvd.storeDataBase.domain.exceptions;

public class CantDeleteInexistentProductException extends Exception{
    public CantDeleteInexistentProductException(String message) {
        super(message);
    }
}
