package ru.gb.zettro.ezplan.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class EzPlanError extends RuntimeException {
    private int status;
    private String message;
    private Date timestamp;

    public EzPlanError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
