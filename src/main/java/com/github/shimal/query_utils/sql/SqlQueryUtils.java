
package com.github.shimal.query_utils.sql;


public class SqlQueryUtils {



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public static SqlConstrainable and(SqlConstrainable constrainable) {

        return new SqlAnd(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable and(SqlConstrainable... constrainables) {

        return new SqlAnd(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable and(SqlConstrainable constrainable1, SqlConstrainable constrainable2) {

        return new SqlAnd(constrainable1, constrainable2);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable and(Object leftSide, Object rightSide) {

        return new SqlAnd(new SqlConstraint(leftSide, rightSide));
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlOrder asc(String column) {

        return new SqlOrder(column, SqlQuery.ORDER_ASCENDING);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlOrder desc(String column) {

        return new SqlOrder(column, SqlQuery.ORDER_DESCENDING);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable eq(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable gt(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.GREATER_THAN);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable gte(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.GREATER_THAN_OR_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable like(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.LIKE);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable likeLower(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.LIKE_LOWER);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable lt(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.LESS_THAN);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable lte(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.LESS_THAN_OR_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable ne(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.NOT_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable or(SqlConstrainable constrainable) {

        return new SqlOr(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable or(SqlConstrainable... constrainables) {

        return new SqlOr(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable or(SqlConstrainable constrainable1, SqlConstrainable constrainable2) {

        return new SqlOr(constrainable1, constrainable2);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable or(Object leftSide, Object rightSide) {

        return new SqlOr(new SqlConstraint(leftSide, rightSide));
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable where(SqlConstrainable constrainable) {

        return new SqlAnd(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable where(SqlConstrainable... constrainables) {

        return new SqlAnd(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static SqlConstrainable where(String leftSide, String rightSide) {

        return new SqlAnd(new SqlConstraint(leftSide, rightSide));
    }
}
