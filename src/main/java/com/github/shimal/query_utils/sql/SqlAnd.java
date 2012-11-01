
package com.github.shimal.query_utils.sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class SqlAnd implements SqlConstrainable {



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private List<SqlConstrainable> constrainables;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public SqlAnd(SqlConstrainable... constrainables) {

        this.constrainables = new ArrayList<SqlConstrainable>();
        this.constrainables.addAll(Arrays.asList(constrainables));
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    @Override
    public void add(SqlConstrainable constrainable) {

        this.constrainables.add(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public Iterator<SqlConstrainable> getIterator() {

        return constrainables.iterator();
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public int size() {

        return this.constrainables.size();
    }
}
