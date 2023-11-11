package com.aicap.springbootwebapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ErrorResponse {

    private LocalDate timestamp;
    private List<String > message;

    public ErrorResponse(List<String> message) {
        this.message = message;
    }
}
