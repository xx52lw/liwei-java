package com.liwei.common.orm.dialect;


/**
 *
 * MSSQL 数据库方言
 *
 *@file orm.dialect
 *@author liwei
 *@Date：下午8:48 下午8:48
*/
public class MSDialect extends Dialect {

    protected static final String SQL_END_DELIMITER = ";";

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        return MSPageHepler.getLimitString(sql, offset, limit);
    }

    @Override
    public String getCountString(String sql) {
        return MSPageHepler.getCountString(sql);
    }
}
