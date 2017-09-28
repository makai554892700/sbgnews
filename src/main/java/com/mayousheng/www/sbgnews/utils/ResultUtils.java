package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.pojo.Result;

public class ResultUtils {

    public static <T> Result<T> succeed(T data) {
        return new Result<T>(0, "success", data);
    }

    public static <T> Result<T> field(T data) {
        return field(-1, data);
    }

    public static <T> Result<T> field(Integer code, T data) {
        return new Result<T>(code, "field", data);
    }

    public static <T> Result<T> error(T data) {
        return new Result<T>(-2, "error", data);
    }

}
