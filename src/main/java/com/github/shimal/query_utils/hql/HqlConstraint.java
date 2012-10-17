
package com.github.shimal.query_utils.hql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class HqlConstraint implements HqlConstrainable {



    //~ --- [STATIC FIELDS/INITIALIZERS] -------------------------------------------------------------------------------

    public static final int EQUAL                 = 0;
    public static final int LIKE                  = 1;
    public static final int NOT_EQUAL             = 2;
    public static final int LESS_THAN             = 3;
    public static final int LESS_THAN_OR_EQUAL    = 4;
    public static final int GREATER_THAN          = 5;
    public static final int GREATER_THAN_OR_EQUAL = 6;



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private List<HqlConstrainable> constrainables;
    private String                 leftSide;
    private int                    operator;
    private String                 rightSide;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public HqlConstraint(String leftSide, String rightSide) {

        this.leftSide       = leftSide;
        this.rightSide      = rightSide;
        this.constrainables = new ArrayList<HqlConstrainable>();
        this.operator       = EQUAL;
    }



    public HqlConstraint(String leftSide, String rightSide, int operator) {

        this.leftSide       = leftSide;
        this.rightSide      = rightSide;
        this.constrainables = new ArrayList<HqlConstrainable>();
        this.operator       = operator;
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    @Override
    public void add(HqlConstrainable constrainable) {

    }



    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public Iterator<HqlConstrainable> getIterator() {

        return constrainables.iterator();
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public String getLeftSide() {

        return leftSide;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public int getOperator() {

        return operator;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    public String getRightSide() {

        return rightSide;
    }



    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public int size() {

        return constrainables.size();
    }
}
