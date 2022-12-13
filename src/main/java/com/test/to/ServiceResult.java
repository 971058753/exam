package com.test.to;


import lombok.Data;

/**
 * @author feifan.han
 * @date 2022/10/13 09:21
 */
@Data
public class ServiceResult<T> {
    public Integer code;
    public boolean success;
    public T data;

    public static<T> ServiceResult<T> buildSuccess(T data) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setSuccess(true);
        serviceResult.setData(data);
        serviceResult.setCode(200);
        return serviceResult;
    }
}