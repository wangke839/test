package com.wangke.springcloud.mongo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Log implements Serializable {
    private String id;
    private String name;
    private String type;
    private Date created;
}
