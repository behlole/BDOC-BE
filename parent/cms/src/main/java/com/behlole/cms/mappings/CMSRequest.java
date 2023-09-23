package com.behlole.cms.mappings;

import lombok.Getter;
@Getter
public class CMSRequest {
    String name;
    String content;

    public void setContent(Object content) {
        this.content = content.toString();
    }

    public void setName(String name) {
        this.name = name;
    }
}
