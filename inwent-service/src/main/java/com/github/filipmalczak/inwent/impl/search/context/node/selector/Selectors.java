package com.github.filipmalczak.inwent.impl.search.context.node.selector;

import com.github.filipmalczak.inwent.impl.search.sql.Condition;
import org.apache.commons.lang3.NotImplementedException;

public interface Selectors {
    Condition id(String id);
    //fixme content.title is name;
    //fixme content.type is unexposed
    Condition name(Condition.Operator operator, String rhs);
    Condition path(Condition.Operator operator, String rhs);
    Condition uri(String value);

    default Condition url(String value){
        //todo
        throw new NotImplementedException("Coming soon");
    }
    //etc
}
