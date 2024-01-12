package com.solvd.storeDataBase.domain.exceptions;

public class PassportDuplicatedException extends Exception{
    public PassportDuplicatedException(String message) {
        super(message);
    }
}
