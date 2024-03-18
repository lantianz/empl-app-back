package com.ltz.emplInfo.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppResult<T> {
    private Integer code;
    private String msg;
    private Integer expire;
    private T data;//泛型T

    public static <T> AppResult<T> success(Integer code, String msg, Integer expire, T data){
        return new AppResult<>(code, msg, expire, data);
    }

    public static <T> AppResult<T> fail(Integer code, String msg, Integer expire, T data){
        return new AppResult<>(code, msg, expire, data);
    }
}
