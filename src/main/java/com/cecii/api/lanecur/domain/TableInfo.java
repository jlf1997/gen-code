package com.cecii.api.lanecur.domain;

import java.util.Date;
import java.util.List;

import com.cecii.base.BaseEntity;
import com.cecii.util.StringUtils;
/**
 * 
 * @author 
 */
public class TableInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    
    /** 表名称 */
    private String tableName;

    /** 表描述 */
    private String tableComment;

    /** 表的主键列信息 */
    private ColumnInfo primaryKey;
    
    /** 多主键的表的主键列信息 */
    private List<ColumnInfo> primaryKeys;

    /** 表的列名(不包含主键) */
    private List<ColumnInfo> columns;

    /** 类名(第一个字母大写) */
    private String className;

    /** 类名(第一个字母小写) */
    private String classname;
    
    private Date createTime;
    
    private Date updateTime;
    
    /** 主键数 */
    private int pkNum;
    
    

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getTableComment()
    {
        return tableComment;
    }

    public void setTableComment(String tableComment)
    {
        this.tableComment = tableComment;
    }

    public List<ColumnInfo> getColumns()
    {
        return columns;
    }

    public ColumnInfo getColumnsLast()
    {
        ColumnInfo columnInfo = null;
        if (StringUtils.isNotNull(columns) && columns.size() > 0)
        {
            columnInfo = columns.get(0);
        }
        return columnInfo;
    }
    
    

    public List<ColumnInfo> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(List<ColumnInfo> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public void setColumns(List<ColumnInfo> columns)
    {
        this.columns = columns;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassname()
    {
        return classname;
    }

    public void setClassname(String classname)
    {
        this.classname = classname;
    }

   

    public int getPkNum() {
		return pkNum;
	}

	public void setPkNum(int pkNum) {
		this.pkNum = pkNum;
	}

	public ColumnInfo getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(ColumnInfo primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Override
    public String toString()
    {
        return "TableInfo [tableName=" + tableName + ", tableComment=" + tableComment 
                + ", columns=" + columns + ", className=" + className + ", classname=" + classname + "]";
    }

	
}
