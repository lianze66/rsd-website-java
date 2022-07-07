package org.rsd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class NewsInfo {

    private Integer id;

    private String name;

    private Integer typeId;

    private String newsPicUrl;

    private String author;

    private String articleSource;

    private String content;

    private String releaseTime;

    private Integer viewsNumber;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone= "GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone= "GMT+8")
    private Date updateTime;

    private String typeName;
}
