package com.example.demo.config;


import lombok.Data;

@Data
public class ResponseBean <T>{
    private boolean success;
    private T data;
    private String code;
    private String msg;

    public ResponseBean(){}

    public ResponseBean(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }


    public ResponseBean(boolean success, T data, String errCode, String msg) {
        super();
        this.success = success;
        this.data = data;
        this.code = errCode;
        this.msg = msg;
    }

    public ResponseBean(boolean success, String errCode, String msg) {
        this.success = success;
        this.code = errCode;
        this.msg = msg;
    }
    public ResponseBean(boolean success,UnicomResponseEnums enums){
        this.success=success;
        this.code =enums.getCode();
        this.msg =enums.getMsg();
    }
    public ResponseBean(boolean success,T data,UnicomResponseEnums enums){
        this.success=success;
        this.data=data;
        this.code =enums.getCode();
        this.msg =enums.getMsg();
    }

}
