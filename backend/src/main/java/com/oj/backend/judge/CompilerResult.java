package com.oj.backend.judge;

public class CompilerResult {
    private boolean success;
    private String result;

    public CompilerResult(boolean success, String result) {
        this.success = success;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}