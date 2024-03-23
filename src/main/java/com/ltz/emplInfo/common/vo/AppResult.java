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
    private T page;

    public <T> AppResult(String msg) {
    }

    public <T> AppResult(String msg, Integer code, T page) {
    }

    public <T> AppResult(Integer code, String msg, Integer expire, T data) {
    }

    public static <T> AppResult<T> success(Integer code, String msg, Integer expire, T data) {
        return new AppResult<>(code, msg, expire, data);
    }

    public static <T> AppResult<T> fail(Integer code, String msg, Integer expire, T data) {
        return new AppResult<>(code, msg, expire, data);
    }

    public static <T> AppResult<T> successByPage(String msg, Integer code, T page) {
        return new AppResult<>(msg, code, page);
    }

}
