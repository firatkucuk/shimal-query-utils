
package com.github.shimal.query_utils.sql;

import com.github.shimal.query_utils.Constrainable;



public class SqlQueryUtils {



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public static Constrainable and(Constrainable constrainable) {

        return new SqlAnd(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable and(Constrainable... constrainables) {

        return new SqlAnd(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable and(Constrainable constrainable1, Constrainable constrainable2) {

        return new SqlAnd(constrainable1, constrainable2);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable and(Object leftSide, Object rightSide) {

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

    public static Constrainable eq(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable gt(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.GREATER_THAN);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable gte(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.GREATER_THAN_OR_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable like(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.LIKE);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable likeLower(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.LIKE_LOWER);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable lt(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.LESS_THAN);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable lte(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.LESS_THAN_OR_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable ne(Object leftSide, Object rightSide) {

        return new SqlConstraint(leftSide, rightSide, SqlConstraint.NOT_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable or(Constrainable constrainable) {

        return new SqlOr(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable or(Constrainable... constrainables) {

        return new SqlOr(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable or(Constrainable constrainable1, Constrainable constrainable2) {

        return new SqlOr(constrainable1, constrainable2);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable or(Object leftSide, Object rightSide) {

        return new SqlOr(new SqlConstraint(leftSide, rightSide));
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable where(Constrainable constrainable) {

        return new SqlAnd(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable where(Constrainable... constrainables) {

        return new SqlAnd(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable where(String leftSide, String rightSide) {

        return new SqlAnd(new SqlConstraint(leftSide, rightSide));
    }
}
