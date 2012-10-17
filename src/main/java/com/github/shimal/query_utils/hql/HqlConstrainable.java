
package com.github.shimal.query_utils.hql;

import java.util.Iterator;



public interface HqlConstrainable {



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    public void add(HqlConstrainable constrainable);



    //~ ----------------------------------------------------------------------------------------------------------------

    public Iterator<HqlConstrainable> getIterator();



    //~ ----------------------------------------------------------------------------------------------------------------

    public int size();
}
