package com.cecii.api.lanecur.service;

import java.util.List;
import java.util.zip.ZipOutputStream;

import org.apache.velocity.VelocityContext;

import com.cecii.api.lanecur.domain.TableInfo;


/**
 * 代码生成 服务层
 * 
 */
public interface IGenService
{
    /**
     * 查询ry数据库表信息
     * 
     * @param tableInfo 表信息
     * @return 数据库表列表
     */
    public List<TableInfo> selectTableList(TableInfo tableInfo);

    /**
     * 生成代码
     * 
     * @param tableName 表名称
     * @return 数据
     */
    public byte[] generatorCode(String tableName,String dataBaseName);
    
    /**
     * 批量生成代码
     * 
     * @param tableNames 表数组
     * @return 数据
     */
    public byte[] generatorCode(String[] tableNames,String dataBaseName);
    
    /**
     * 生成特定模板
     * @param template
     * @param velocityContext
     * @param zip
     */
    public String generatorCode(String template, VelocityContext velocityContext);
    
    public List<String> getAllTables(String dataBaseName);
}
