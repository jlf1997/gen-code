package com.cecii.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取代码生成相关配置
 * 
 */
@Component
@ConfigurationProperties(prefix = "gen")
public class GenConfig
{
    /** 作者 */
    public static String author;
    /** 生成包路径 */
    public static String packageName;
    /** 自动去除表前缀，默认是true */
    public static String autoRemovePre;
    /** 表前缀(类名不会包含表前缀) */
    public static String tablePrefix;
    
    public static String classPrefix = "";
    
    public static String assistUrl = "";
    
    public static boolean hasPageOp = false;

    public static String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        GenConfig.author = author;
    }

    public static String getPackageName()
    {
        return packageName;
    }

    public void setPackageName(String packageName)
    {
        GenConfig.packageName = packageName;
    }

    public static String getAutoRemovePre()
    {
        return autoRemovePre;
    }

    public void setAutoRemovePre(String autoRemovePre)
    {
        GenConfig.autoRemovePre = autoRemovePre;
    }

    public static String getTablePrefix()
    {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix)
    {
        GenConfig.tablePrefix = tablePrefix;
    }
    
    

    public static String getClassPrefix() {
		return classPrefix;
	}

	public static void setClassPrefix(String classPrefix) {
		GenConfig.classPrefix = classPrefix;
	}
	
	

	public static String getAssistUrl() {
		return assistUrl;
	}

	public static void setAssistUrl(String assistUrl) {
		GenConfig.assistUrl = assistUrl;
	}

	public static boolean isHasPageOp() {
		return hasPageOp;
	}

	public static void setHasPageOp(boolean hasPageOp) {
		GenConfig.hasPageOp = hasPageOp;
	}

	@Override
    public String toString()
    {
        return "GenConfig [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }
}
