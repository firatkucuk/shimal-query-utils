
package com.github.shimal.query_utils.hql;


public class HqlQueryUtils {



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public static HqlConstrainable and(HqlConstrainable constrainable) {

        return new HqlAnd(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable and(HqlConstrainable... constrainables) {

        return new HqlAnd(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable and(HqlConstrainable constrainable1, HqlConstrainable constrainable2) {

        return new HqlAnd(constrainable1, constrainable2);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable and(Object leftSide, Object rightSide) {

        return new HqlAnd(new HqlConstraint(leftSide, rightSide));
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlOrder asc(String column) {

        return new HqlOrder(column, HqlQuery.ORDER_ASCENDING);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlOrder desc(String column) {

        return new HqlOrder(column, HqlQuery.ORDER_DESCENDING);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable eq(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable gt(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.GREATER_THAN);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable gte(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.GREATER_THAN_OR_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable like(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.LIKE);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable likeLower(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.LIKE_LOWER);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable lt(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.LESS_THAN);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable lte(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.LESS_THAN_OR_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable ne(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.NOT_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable or(HqlConstrainable constrainable) {

        return new HqlOr(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable or(HqlConstrainable... constrainables) {

        return new HqlOr(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable or(HqlConstrainable constrainable1, HqlConstrainable constrainable2) {

        return new HqlOr(constrainable1, constrainable2);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable or(Object leftSide, Object rightSide) {

        return new HqlOr(new HqlConstraint(leftSide, rightSide));
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable where(HqlConstrainable constrainable) {

        return new HqlAnd(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable where(HqlConstrainable... constrainables) {

        return new HqlAnd(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static HqlConstrainable where(String leftSide, String rightSide) {

        return new HqlAnd(new HqlConstraint(leftSide, rightSide));
    }
}
