
package com.github.shimal.query_utils.hql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class HqlAnd implements HqlConstrainable {



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private List<HqlConstrainable> constrainables;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public HqlAnd(HqlConstrainable... constrainables) {

        this.constrainables = new ArrayList<HqlConstrainable>();
        this.constrainables.addAll(Arrays.asList(constrainables));
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    @Override
    public void add(HqlConstrainable constrainable) {

        this.constrainables.add(constrainable);
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public Iterator<HqlConstrainable> getIterator() {

        return constrainables.iterator();
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public int size() {

        return this.constrainables.size();
    }
}
