package com.serket.cloud.util;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

@Intercepts({@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class})})
public class PageHelper implements Interceptor {



    private String dialect;

    public Object intercept(Invocation invocation) throws Throwable {
        final RoutingStatementHandler handler = (RoutingStatementHandler) invocation
                .getTarget();
        final StatementHandler delegate = (StatementHandler) ReflectUtil
                .getFieldValue(handler, "delegate");
        final BoundSql boundSql = delegate.getBoundSql();
        final Object obj = boundSql.getParameterObject();
        if (obj instanceof Page) {
            final Page page = (Page) obj;
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil
                    .getFieldValue(delegate, "mappedStatement");
            Connection connection = (Connection) invocation.getArgs()[0];
            final String sql = boundSql.getSql();
            this.setTotalRecord(page, mappedStatement, connection);
            final String pageSql = this.getPageSql(page, sql);
            ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        this.dialect = properties.getProperty("dialect");
    }

    private String getPageSql(Page page, String sql) {
        final StringBuffer sqlBuffer = new StringBuffer(sql);
        if ("mysql".equalsIgnoreCase(dialect)) {
            return getMysqlPageSql(page, sqlBuffer);
        } else if ("oracle".equalsIgnoreCase(dialect)) {
            return getOraclePageSql(page, sqlBuffer);
        }
        return sqlBuffer.toString();
    }

    private String getMysqlPageSql(Page page, StringBuffer sqlBuffer) {
        // 计算第一条记录的位置，Mysql中记录的位置是从0开始的。
        // int offset = (page.getPage().getPageIndex() - 1) *
        // page.getPageSize();
        sqlBuffer.append(" limit ")
                .append((page.getPage() - 1) * page.getRows()).append(",")
                .append(page.getRows());
        return sqlBuffer.toString();
    }

    private String getOraclePageSql(Page page, StringBuffer sqlBuffer) {
         final int offset = (page.getPage() - 1) * page.getRows() + 1;
        sqlBuffer.insert(0, "select u.*, rownum r from (")
                .append(") u where rownum < ").append(offset + page.getRows());
        sqlBuffer.insert(0, "select * from (").append(") where r >= ")
                .append(offset);
         return sqlBuffer.toString();
    }

    private void setTotalRecord(Page page, MappedStatement mappedStatement,
                                Connection connection) {
        final BoundSql boundSql = mappedStatement.getBoundSql(page);
         final String sql = boundSql.getSql();
         final String countSql = this.getCountSql(sql);
         final List<ParameterMapping> parameterMappings = boundSql
                .getParameterMappings();
         final BoundSql countBoundSql = new BoundSql(
                mappedStatement.getConfiguration(), countSql,
                parameterMappings, page);
         final ParameterHandler parameterHandler = new DefaultParameterHandler(
                mappedStatement, page, countBoundSql);
         PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(countSql);
             parameterHandler.setParameters(pstmt);
             rs = pstmt.executeQuery();
            if (rs.next()) {
                final int totalRecord = rs.getInt(1);
                 page.setTotal(totalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCountSql(String sql) {
        final int index = sql.toLowerCase().indexOf("from");
        return "select count(*) " + sql.substring(index);
    }

    private static class ReflectUtil {
        public static Object getFieldValue(Object obj, String fieldName) {
            Object result = null;
            final Field field = ReflectUtil.getField(obj, fieldName);
            if (field != null) {
                field.setAccessible(true);
                try {
                    result = field.get(obj);
                } catch (IllegalArgumentException e) {
                     e.printStackTrace();
                } catch (IllegalAccessException e) {
                     e.printStackTrace();
                }
            }
            return result;
        }

        private static Field getField(Object obj, String fieldName) {
            Field field = null;
            for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz
                    .getSuperclass()) {
                try {
                    field = clazz.getDeclaredField(fieldName);
                    break;
                } catch (NoSuchFieldException e) {
                 }
            }
            return field;
        }

        public static void setFieldValue(Object obj, String fieldName,
                                         String fieldValue) {
            final Field field = ReflectUtil.getField(obj, fieldName);
            if (field != null) {
                try {
                    field.setAccessible(true);
                    field.set(obj, fieldValue);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }
}
