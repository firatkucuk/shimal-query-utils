
package com.github.shimal.query_utils.sql;


public class SqlOrder {



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private String column;
    private int    method;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public SqlOrder(String column, int method) {

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
