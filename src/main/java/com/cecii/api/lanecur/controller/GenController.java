package com.cecii.api.lanecur.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cecii.api.lanecur.domain.TableInfo;
import com.cecii.api.lanecur.service.IGenService;
import com.cecii.base.BaseController;
import com.cecii.util.Convert;
import com.cimr.boot.comm.model.HttpResult;

/**
 * 代码生成 操作处理
 * 
 * @author slwu
 */
@Controller
@RequestMapping("/tool/gen")
public class GenController extends BaseController
{
    private String prefix = "tool/gen";

    @Autowired
    private IGenService genService;

    @GetMapping()
    public String gen()
    {
        return prefix + "/gen";
    }

    @PostMapping("/list")
    @ResponseBody
    public HttpResult list(TableInfo tableInfo){
        List<TableInfo> list = genService.selectTableList(tableInfo);
        return new HttpResult().retSuccess(list);
    }

    /**
     * 生成代码
     */
    @GetMapping("/genCode/{dataBaseName}/{tableName}")
    public void genCode(HttpServletResponse response
    		, @PathVariable("tableName") String tableName
    		, @PathVariable("dataBaseName") String dataBaseName
    		) throws IOException
    {
        byte[] data = genService.generatorCode(tableName,dataBaseName);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

    /**
     * 批量生成代码
     */
    @GetMapping("/batchGenCode/{dataBaseName}")
    @ResponseBody
    public void batchGenCode(HttpServletResponse response
    		, String tables
    		, @PathVariable("dataBaseName") String dataBaseName
    		) throws IOException
    {
    	String[] tableNames;
    	if(tables==null) {//获取所有表
    		List<String> strs = genService.getAllTables(dataBaseName);
    		tableNames = new String[strs.size()];
    		tableNames = strs.toArray(tableNames);
    	}else {
    		tableNames = Convert.toStrArray(tables);
    	}
        
        byte[] data = genService.generatorCode(tableNames,dataBaseName);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
    
    @GetMapping("/genSqlFunction")
    @ResponseBody
    public void genSqlFunction(HttpServletResponse response,
    		String functionName,
    		String sql
    		) throws IOException{
   	 	VelocityContext velocityContext = new VelocityContext();
   	 	velocityContext.put("functionName", functionName);
   	 	velocityContext.put("sql", sql);
        byte[] data = genService.generatorCode("templates/vm/mybatis/sqlTemp.vm",velocityContext).getBytes();
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\""+functionName+".txt\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}
