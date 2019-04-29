package com.cecii.api.lanecur.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cecii.api.lanecur.domain.ColumnInfo;
import com.cecii.api.lanecur.domain.TableInfo;


/**
 * 代码生成 数据层
 * 
 * @author ruoyi
 */
public interface GenMapper
{
    /**
     * 查询ry数据库表信息
     * 
     * @param tableInfo 表信息
     * @return 数据库表列表
     */
    public List<TableInfo> selectTableList(TableInfo tableInfo);

    /**
     * 根据表名称查询信息
     * 
     * @param tableName 表名称
     * @return 表信息
     */
    public TableInfo selectTableByName(@Param("tableName") String tableName,@Param("tableSchema") String tableSchema);

    /**
     * 根据表名称查询列信息
     * 
     * @param tableName 表名称
     * @return 列信息
     */
    public List<ColumnInfo> selectTableColumnsByName(String tableName);
}
