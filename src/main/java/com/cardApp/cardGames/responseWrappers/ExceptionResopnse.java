package com.cardApp.cardGames.responseWrappers;

public class ExceptionResopnse {
    private String msg;

    public ExceptionResopnse(String msg) {
        this.msg = msg;
    }


    public String getMsg() {
        return this.msg;
    }

}
