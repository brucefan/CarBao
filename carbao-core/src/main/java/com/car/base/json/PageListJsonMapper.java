package com.car.base.json;

import com.car.base.page.PageList;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.Serializable;

public class PageListJsonMapper extends ObjectMapper implements Serializable {

    private static final long serialVersionUID = 7873352149884333277L;

    public PageListJsonMapper() {
        SimpleModule module = new SimpleModule("PageListJSONModule", new Version(1, 0, 0, null, null, null));
        module.addSerializer(PageList.class, new PageListJsonSerializer(this));
        registerModule(module);
    }
}
