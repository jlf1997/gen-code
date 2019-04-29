package com.cecii.base;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Maps;
import com.google.gson.annotations.Expose;

/**
 * Entity基类
 * 
 * @author ruoyi
 */
public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 搜索值 */
    protected String searchValue;


    /** 请求参数 */
    protected Map<String, Object> params;

    public String getSearchValue()
    {
        return searchValue;
    }

    public void setSearchValue(String searchValue)
    {
        this.searchValue = searchValue;
    }

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = Maps.newHashMap();
        }
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
}
