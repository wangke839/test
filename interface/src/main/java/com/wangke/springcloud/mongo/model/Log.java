package com.wangke.springcloud.mongo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private String id;
    private String name;
    private String type;
    private Date created;
}
