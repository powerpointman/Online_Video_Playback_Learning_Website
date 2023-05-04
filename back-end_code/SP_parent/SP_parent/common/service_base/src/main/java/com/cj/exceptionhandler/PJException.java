package com.cj.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //生成get和set
@AllArgsConstructor //生成有参数的构造方法
@NoArgsConstructor //生成无参构造
public class PJException extends RuntimeException{
    private Integer code;//状态码
    private String msg;//异常信息


}
