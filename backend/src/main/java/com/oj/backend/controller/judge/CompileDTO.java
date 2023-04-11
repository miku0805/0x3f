package com.oj.backend.controller.judge;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompileDTO implements Serializable {
    private String code;

    private String inputStr;
}
