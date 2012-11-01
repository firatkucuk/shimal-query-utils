
package com.github.shimal.query_utils.hql;

import com.github.shimal.query_utils.Constrainable;



public class HqlQueryUtils {



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public static Constrainable and(Constrainable constrainable) {

        return new HqlAnd(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable and(Constrainable... constrainables) {

        return new HqlAnd(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable and(Constrainable constrainable1, Constrainable constrainable2) {

        return new HqlAnd(constrainable1, constrainable2);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable and(Object leftSide, Object rightSide) {

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

    public static Constrainable eq(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable gt(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.GREATER_THAN);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable gte(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.GREATER_THAN_OR_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable like(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.LIKE);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable likeLower(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.LIKE_LOWER);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable lt(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.LESS_THAN);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable lte(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.LESS_THAN_OR_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable ne(Object leftSide, Object rightSide) {

        return new HqlConstraint(leftSide, rightSide, HqlConstraint.NOT_EQUAL);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable or(Constrainable constrainable) {

        return new HqlOr(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable or(Constrainable... constrainables) {

        return new HqlOr(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable or(Constrainable constrainable1, Constrainable constrainable2) {

        return new HqlOr(constrainable1, constrainable2);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable or(Object leftSide, Object rightSide) {

        return new HqlOr(new HqlConstraint(leftSide, rightSide));
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable where(Constrainable constrainable) {

        return new HqlAnd(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable where(Constrainable... constrainables) {

        return new HqlAnd(constrainables);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public static Constrainable where(String leftSide, String rightSide) {

        return new HqlAnd(new HqlConstraint(leftSide, rightSide));
    }
}
