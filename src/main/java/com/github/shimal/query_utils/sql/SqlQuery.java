
package com.github.shimal.query_utils.sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;



public class SqlQuery {



    //~ --- [STATIC FIELDS/INITIALIZERS] -------------------------------------------------------------------------------

    public static final int ORDER_ASCENDING  = 0;
    public static final int ORDER_DESCENDING = 1;



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private String                  countParam;
    private List<SqlOrder>          orders;
    private String                  selectParam;
    private HashMap<String, String> tables;
    private SqlConstrainable        topConstrainable;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public SqlQuery(String table) {

        this(table, "S");
    }



    public SqlQuery(String table, String alias) {

        tables           = new HashMap<String, String>();
        orders           = new ArrayList<SqlOrder>();
        topConstrainable = null;
        countParam       = alias;
        selectParam      = alias;

        tables.put(alias, table);
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public SqlQuery asc(String column) {

        this.orders.add(new SqlOrder(column, ORDER_ASCENDING));

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public String count() {

        return "SELECT COUNT(" + countParam + ") FROM " + generateSelectWoTable();
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public SqlQuery desc(String column) {

        this.orders.add(new SqlOrder(column, ORDER_DESCENDING));

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public String getCountParam() {

        return countParam;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public String getSelectParam() {

        return selectParam;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public SqlQuery join(String table, String alias) throws TableAliasAlreadyUsedException {

        if (tables.containsKey(alias)) {
            throw new TableAliasAlreadyUsedException();
        }

        tables.put(alias, table);

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public SqlQuery join(String table, String alias, SqlConstrainable constraint)
        throws TableAliasAlreadyUsedException {

        if (tables.containsKey(alias)) {
            throw new TableAliasAlreadyUsedException();
        }

        tables.put(alias, table);
        where(constraint);

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public SqlQuery join(String table, String alias, String leftSide, String rightSide)
        throws TableAliasAlreadyUsedException {

        if (tables.containsKey(alias)) {
            throw new TableAliasAlreadyUsedException();
        }

        tables.put(alias, table);
        where(leftSide, rightSide);

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public SqlQuery order(SqlOrder... orders) {

        this.orders.addAll(Arrays.asList(orders));

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public String select() {

        return "SELECT " + selectParam + " FROM " + generateSelectWoTable() + generateOrders();
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public void setCountParam(String countParam) {

        this.countParam = countParam;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public void setSelectParam(String selectParam) {

        this.selectParam = selectParam;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public SqlQuery where(SqlConstrainable constrainable) {

        if (topConstrainable == null) {

            if (constrainable instanceof SqlConstraint) {
                topConstrainable = new SqlAnd(constrainable);
            } else {
                topConstrainable = constrainable;
            }
        } else {
            topConstrainable.add(constrainable);
        }

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public SqlQuery where(Object leftSide, Object rightSide) {

        SqlConstraint constraint = new SqlConstraint(leftSide, rightSide);

        if (topConstrainable == null) {
            topConstrainable = new SqlAnd(constraint);
        } else {
            topConstrainable.add(constraint);
        }

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    private String generateOrders() {

        String query = "";

        for (SqlOrder hqlOrder : orders) {
            query += ", " + hqlOrder.getColumn() + (hqlOrder.getMethod() == ORDER_ASCENDING ? " ASC" : " DESC");
        }

        if (!query.isEmpty()) {
            query = " ORDER BY " + query.substring(2);
        }

        return query;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    private String generateSelectWoTable() {

        String query = "";

        for (String alias : tables.keySet()) {
            query += ", " + tables.get(alias) + " " + alias;
        }

        query = query.substring(2);

        if (topConstrainable != null && topConstrainable.size() > 0) {
            query += " WHERE " + wh(topConstrainable);
        }

        return query;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    private String wh(SqlConstrainable constrainable) {

        String                     query      = "";
        Iterator<SqlConstrainable> iterator   = constrainable.getIterator();
        String                     whereQuery = "";

        if (constrainable instanceof SqlConstraint) {
            SqlConstraint constraint = (SqlConstraint) constrainable;

            if (constraint.getOperator() == SqlConstraint.EQUAL) {
                query += constraint.getLeftSide() + " = " + constraint.getRightSide();
            } else if (constraint.getOperator() == SqlConstraint.NOT_EQUAL) {
                query += constraint.getLeftSide() + " != " + constraint.getRightSide();
            } else if (constraint.getOperator() == SqlConstraint.LIKE) {
                query += constraint.getLeftSide() + " LIKE " + constraint.getRightSide();
            } else if (constraint.getOperator() == SqlConstraint.LIKE_LOWER) {
                query += "LOWER(" + constraint.getLeftSide() + ") LIKE LOWER(" + constraint.getRightSide() + ")";
            } else if (constraint.getOperator() == SqlConstraint.LESS_THAN) {
                query += constraint.getLeftSide() + " < " + constraint.getRightSide();
            } else if (constraint.getOperator() == SqlConstraint.LESS_THAN_OR_EQUAL) {
                query += constraint.getLeftSide() + " <= " + constraint.getRightSide();
            } else if (constraint.getOperator() == SqlConstraint.GREATER_THAN) {
                query += constraint.getLeftSide() + " > " + constraint.getRightSide();
            } else if (constraint.getOperator() == SqlConstraint.GREATER_THAN_OR_EQUAL) {
                query += constraint.getLeftSide() + " >= " + constraint.getRightSide();
            }
        } else if (constrainable instanceof SqlAnd) {

            while (iterator.hasNext()) {
                whereQuery += " AND " + wh(iterator.next());
            }

            query += "(" + whereQuery.substring(5) + ")";
        } else if (constrainable instanceof SqlOr) {

            while (iterator.hasNext()) {
                whereQuery += " OR " + wh(iterator.next());
            }

            query += "(" + whereQuery.substring(4) + ")";
        }

        return query;
    }
}
