
package com.github.shimal.query_utils.hql;

import com.github.shimal.query_utils.Orderable;



public class HqlOrder implements Orderable {



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private String column;
    private int    method;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public HqlOrder(String column, int method) {

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
