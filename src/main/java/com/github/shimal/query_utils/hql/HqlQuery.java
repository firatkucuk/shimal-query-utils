
package com.github.shimal.query_utils.hql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;



public class HqlQuery {



    //~ --- [STATIC FIELDS/INITIALIZERS] -------------------------------------------------------------------------------

    public static final int ORDER_ASCENDING  = 0;
    public static final int ORDER_DESCENDING = 1;



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private String                  countParam;
    private HashMap<String, String> entities;
    private List<HqlOrder>          orders;
    private String                  selectParam;
    private HqlConstrainable        topConstrainable;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public HqlQuery(Class entity) {

        this(entity, "s");
    }



    public HqlQuery(Class entity, String alias) {

        entities         = new HashMap<String, String>();
        orders           = new ArrayList<HqlOrder>();
        topConstrainable = new HqlAnd();
        topConstrainable = null;
        countParam       = alias;
        selectParam      = alias;

        entities.put(alias, entity.getSimpleName());
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public HqlQuery asc(String column) {

        this.orders.add(new HqlOrder(column, ORDER_ASCENDING));

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public String count() {

        return "select count(" + countParam + ") from " + generateSelectWoEntity();
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public HqlQuery desc(String column) {

        this.orders.add(new HqlOrder(column, ORDER_DESCENDING));

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

    public HqlQuery join(Class entity, String alias) throws EntityAliasAlreadyUsedException {

        if (entities.containsKey(alias)) {
            throw new EntityAliasAlreadyUsedException();
        }

        entities.put(alias, entity.getSimpleName());

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public HqlQuery join(Class entity, String alias, HqlConstrainable constraint)
        throws EntityAliasAlreadyUsedException {

        if (entities.containsKey(alias)) {
            throw new EntityAliasAlreadyUsedException();
        }

        entities.put(alias, entity.getSimpleName());
        where(constraint);

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public HqlQuery join(Class entity, String alias, String leftSide, String rightSide)
        throws EntityAliasAlreadyUsedException {

        if (entities.containsKey(alias)) {
            throw new EntityAliasAlreadyUsedException();
        }

        entities.put(alias, entity.getSimpleName());
        where(leftSide, rightSide);

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public HqlQuery order(HqlOrder... orders) {

        this.orders.addAll(Arrays.asList(orders));

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public String select() {

        return "select " + selectParam + " from " + generateSelectWoEntity() + generateOrders();
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

    public HqlQuery where(HqlConstrainable constrainable) {

        if (topConstrainable == null) {

            if (constrainable instanceof HqlConstraint) {
                topConstrainable = new HqlAnd(constrainable);
            } else {
                topConstrainable = constrainable;
            }
        } else {
            topConstrainable.add(constrainable);
        }

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public HqlQuery where(Object leftSide, Object rightSide) {

        HqlConstraint constraint = new HqlConstraint(leftSide.toString(), rightSide.toString());

        if (topConstrainable == null) {
            topConstrainable = new HqlAnd(constraint);
        } else {
            topConstrainable.add(constraint);
        }

        return this;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    private String generateOrders() {

        String query = "";

        for (HqlOrder hqlOrder : orders) {
            query += ", " + hqlOrder.getColumn() + (hqlOrder.getMethod() == ORDER_ASCENDING ? " asc" : " desc");
        }

        if (!query.isEmpty()) {
            query = " order by " + query.substring(2);
        }

        return query;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    private String generateSelectWoEntity() {

        String query = "";

        for (String alias : entities.keySet()) {
            query += ", " + entities.get(alias) + " " + alias;
        }

        query = query.substring(2);

        if (topConstrainable.size() > 0) {
            query += " where " + wh(topConstrainable);
        }

        return query;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    private String wh(HqlConstrainable constrainable) {

        String                     query      = "";
        Iterator<HqlConstrainable> iterator   = constrainable.getIterator();
        String                     whereQuery = "";

        if (constrainable instanceof HqlConstraint) {
            HqlConstraint constraint = (HqlConstraint) constrainable;

            if (constraint.getOperator() == HqlConstraint.EQUAL) {
                query += constraint.getLeftSide() + " = " + constraint.getRightSide();
            } else if (constraint.getOperator() == HqlConstraint.NOT_EQUAL) {
                query += constraint.getLeftSide() + " != " + constraint.getRightSide();
            } else if (constraint.getOperator() == HqlConstraint.LIKE) {
                query += constraint.getLeftSide() + " LIKE " + constraint.getRightSide();
            } else if (constraint.getOperator() == HqlConstraint.LIKE_LOWER) {
                query += "lower(" + constraint.getLeftSide() + ") like lower('" + constraint.getRightSide() + "')";
            } else if (constraint.getOperator() == HqlConstraint.LESS_THAN) {
                query += constraint.getLeftSide() + " < " + constraint.getRightSide();
            } else if (constraint.getOperator() == HqlConstraint.LESS_THAN_OR_EQUAL) {
                query += constraint.getLeftSide() + " <= " + constraint.getRightSide();
            } else if (constraint.getOperator() == HqlConstraint.GREATER_THAN) {
                query += constraint.getLeftSide() + " > " + constraint.getRightSide();
            } else if (constraint.getOperator() == HqlConstraint.GREATER_THAN_OR_EQUAL) {
                query += constraint.getLeftSide() + " >= " + constraint.getRightSide();
            }
        } else if (constrainable instanceof HqlAnd) {

            while (iterator.hasNext()) {
                whereQuery += " and " + wh(iterator.next());
            }

            query += "(" + whereQuery.substring(5) + ")";
        } else if (constrainable instanceof HqlOr) {

            while (iterator.hasNext()) {
                whereQuery += " or " + wh(iterator.next());
            }

            query += "(" + whereQuery.substring(4) + ")";
        }

        return query;
    }
}
