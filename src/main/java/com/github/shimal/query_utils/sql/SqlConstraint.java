
package com.github.shimal.query_utils.sql;

import com.github.shimal.query_utils.Constrainable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class SqlConstraint implements Constrainable {



    //~ --- [STATIC FIELDS/INITIALIZERS] -------------------------------------------------------------------------------

    public static final int EQUAL                 = 0;
    public static final int NOT_EQUAL             = 1;
    public static final int LIKE                  = 2;
    public static final int LIKE_LOWER            = 3;
    public static final int LESS_THAN             = 4;
    public static final int LESS_THAN_OR_EQUAL    = 5;
    public static final int GREATER_THAN          = 6;
    public static final int GREATER_THAN_OR_EQUAL = 7;



    //~ --- [INSTANCE FIELDS] ------------------------------------------------------------------------------------------

    private List<Constrainable> constrainables;
    private String              leftSide;
    private int                 operator;
    private String              rightSide;



    //~ --- [CONSTRUCTORS] ---------------------------------------------------------------------------------------------

    public SqlConstraint(Object leftSide, Object rightSide) {

        this(leftSide, rightSide, EQUAL);
    }



    public SqlConstraint(Object leftSide, Object rightSide, int operator) {

        this.leftSide       = leftSide.toString();
        this.rightSide      = rightSide.toString();
        this.constrainables = new ArrayList<Constrainable>();
        this.operator       = operator;
    }



    //~ --- [METHODS] --------------------------------------------------------------------------------------------------

    @Override
    public void add(Constrainable constrainable) {

    }



    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public Iterator<Constrainable> getIterator() {

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
