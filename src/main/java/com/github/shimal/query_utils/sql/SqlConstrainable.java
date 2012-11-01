
package com.github.shimal.query_utils.sql;

import java.util.Iterator;



public interface SqlConstrainable {



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public void add(SqlConstrainable constrainable);



    //~ ----------------------------------------------------------------------------------------------------------------

    public Iterator<SqlConstrainable> getIterator();



    //~ ----------------------------------------------------------------------------------------------------------------

    public int size();
}
