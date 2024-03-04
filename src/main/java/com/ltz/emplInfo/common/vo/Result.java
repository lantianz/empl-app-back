package com.ltz.emplInfo.common.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private Integer total;
    private T data;//泛型T
    private T data1;

    public static <T> Result<T> success(Integer total, T data, T data1){
        return new Result<>(20000,"success",total, data, data1);
    }



    public static <T> Result<T> success(){
        return new Result<>(20000,"success",null,null,null);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(20000,"success",null,data,null);
    }

    public static <T> Result<T> success(T data, String message){
        return new Result<>(20000,message,null,data,null);
    }

    public static <T> Result<T> success(String message){
        return new Result<>(20000,message,null,null,null);
    }

    public static <T> Result<T> fail(){
        return new Result<>(20001,"fail",null,null,null);
    }

    public static <T> Result<T> fail(Integer code){
        return new Result<>(code,"fail",null,null,null);
    }

    public static <T> Result<T> fail(Integer code, String message){
        return new Result<>(code,message,null,null,null);
    }

    public static <T> Result<T> fail(String message){
        return new Result<>(20001,message,null,null,null);
    }
}
