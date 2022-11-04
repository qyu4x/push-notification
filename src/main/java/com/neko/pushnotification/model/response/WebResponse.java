package com.neko.pushnotification.model.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class WebResponse<T> {

    private Integer code;

    private String status;

    private T data;

}
