package com.bavlo.counter.config;

import org.hibernate.cfg.ImprovedNamingStrategy;

import com.bavlo.counter.model.IdEntity;


@SuppressWarnings("serial")
public class LocalNamingStrategy extends ImprovedNamingStrategy {

	private String tablePrefix = IdEntity.tablePrefix;
	
	public String tableName(String tableName) {
		
		if(tableName.startsWith("sys_") || tableName.startsWith("cms_") || tableName.startsWith("tf_"))
			return tablePrefix + tableName;
		else
			return tableName;
	}
	public String classToTableName(String className) {
		return  super.classToTableName(className);
	}

	public String foreignKeyColumnName(String propertyName,
			String propertyEntityName, String propertyTableName,
			String referencedColumnName) {
		return super.foreignKeyColumnName(propertyName, propertyEntityName,
				propertyTableName, referencedColumnName)
				+ "_id";
	}
	
	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}
	
	
	//public static List<String> tableNames;
}
