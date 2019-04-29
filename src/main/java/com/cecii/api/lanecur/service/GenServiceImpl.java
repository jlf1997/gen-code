package com.cecii.api.lanecur.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecii.api.lanecur.dao.GenMapper;
import com.cecii.api.lanecur.domain.ColumnInfo;
import com.cecii.api.lanecur.domain.TableInfo;
import com.cecii.common.BaseException;
import com.cecii.common.Constants;
import com.cecii.config.GenConfig;
import com.cecii.util.GenUtils;
import com.cecii.util.StringUtils;
import com.cecii.util.VelocityInitializer;


/**
 * 代码生成 服务层处理
 * 
 */
@Service
public class GenServiceImpl implements IGenService
{
    @Autowired
    private GenMapper genMapper;

    /**
     * 查询ry数据库表信息
     * 
     * @param tableInfo 表信息
     * @return 数据库表列表
     */
    @Override
    public List<TableInfo> selectTableList(TableInfo tableInfo)
    {
        return genMapper.selectTableList(tableInfo);
    }

    /**
     * 生成代码
     * 
     * @param tableName 表名称
     * @return 数据
     */
    @Override
    public byte[] generatorCode(String tableName,String dataBaseName)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        // 查询表信息
        TableInfo table = genMapper.selectTableByName(tableName,dataBaseName);
        // 查询列信息
        List<ColumnInfo> columns = genMapper.selectTableColumnsByName(tableName);
        // 生成代码
        generatorCode(table, columns, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 批量生成代码
     * 
     * @param tableNames 表数组
     * @return 数据
     */
    @Override
    public byte[] generatorCode(String[] tableNames,String dataBaseName)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames)
        {
            // 查询表信息
            TableInfo table = genMapper.selectTableByName(tableName,dataBaseName);
            // 查询列信息
            List<ColumnInfo> columns = genMapper.selectTableColumnsByName(tableName);
            // 生成代码
            generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 生成代码
     */
    public void generatorCode(TableInfo table, List<ColumnInfo> columns, ZipOutputStream zip)
    {
        // 表名转换成Java属性名
        String className = GenUtils.tableToJava(table.getTableName());
        table.setClassName(className);
        table.setClassname(StringUtils.uncapitalize(className));
        // 列信息
        table.setColumns(GenUtils.transColums(columns));
        // 设置主键
        List<ColumnInfo> pkList = GenUtils.getPrimaryKey(columns);
        table.setPkNum(pkList.size());
     
        if(pkList.size()==1) {
        	 table.setPrimaryKey(pkList.get(0));
        }
        if(pkList.size()>1) {
        	 table.setPrimaryKeys(pkList);
        }
       

        VelocityInitializer.initVelocity();

        String packageName = GenConfig.getPackageName();
        String moduleName = GenUtils.getModuleName(packageName);

        VelocityContext context = GenUtils.getVelocityContext(table);

        // 获取模板列表
        List<String> templates = GenUtils.getTemplates();
        for (String template : templates)
        {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            try
            {
                // 添加到zip
                zip.putNextEntry(new ZipEntry(GenUtils.getFileName(template, table, moduleName)));
                IOUtils.write(sw.toString(), zip, Constants.UTF8);
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            }
            catch (IOException e)
            {
                throw new BaseException("渲染模板失败，表名：" + table.getTableName(), e.getMessage());
            }
        }
    }
}
