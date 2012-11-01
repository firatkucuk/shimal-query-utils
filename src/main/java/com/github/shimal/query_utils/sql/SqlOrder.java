
package com.github.shimal.query_utils.sql;

import com.github.shimal.query_utils.Orderable;



public class SqlOrder implements Orderable {



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private String column;
    private int    method;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public SqlOrder(String column, int method) {

        this.column = column;
        this.method = method;
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    @Override
    public String getColumn() {

        return column;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public int getMethod() {

        return method;
    }
}
