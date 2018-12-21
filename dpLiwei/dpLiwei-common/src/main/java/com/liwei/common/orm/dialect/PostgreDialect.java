package com.liwei.common.orm.dialect;

/**
 *
 * Postgre 数据库 方言
 *
 *@file orm.dialect
 *@author liwei
 *@Date：下午8:49 下午8:49
*/
public class PostgreDialect extends Dialect {

    protected static final String SQL_END_DELIMITER = ";";

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        return PostgrePageHepler.getLimitString(sql, offset, limit);
    }

    @Override
    public String getCountString(String sql) {
        return PostgrePageHepler.getCountString(sql);
    }
}
