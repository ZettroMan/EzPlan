package ru.gb.zettro.ezplan.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class EzPlanError {
    private int status;
    private String message;
    private Date timestamp;

    public EzPlanError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
