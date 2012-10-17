package com.github.shimal.query_utils.hql;

public class HqlOrder {



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private String column;
    private int    method;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public HqlOrder(String column, int method) {

        this.column = column;
        this.method = method;
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public String getColumn() {

        return column;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public int getMethod() {

        return method;
    }
}
