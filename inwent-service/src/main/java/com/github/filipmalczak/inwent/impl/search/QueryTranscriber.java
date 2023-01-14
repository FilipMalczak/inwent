package com.github.filipmalczak.inwent.impl.search;

import com.github.filipmalczak.inwent.api.model.search.query.HitQuery;
import com.github.filipmalczak.inwent.impl.common.visitor.GenericRecordVisitor;
import com.github.filipmalczak.inwent.impl.common.visitor.RecordVisitor;
import com.github.filipmalczak.inwent.impl.search.context.node.HitNode;
import com.github.filipmalczak.inwent.impl.search.context.TranscriptionContext;
import com.github.filipmalczak.inwent.impl.search.sql.All;
import com.github.filipmalczak.inwent.impl.search.sql.Sqlable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static java.util.stream.Collectors.joining;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class QueryTranscriber implements Sqlable {
    HitQuery query;
    HitQuery canonicalQuery;
    String sql;

    TranscriptionContext context;

    public QueryTranscriber(HitQuery query) {
        this.query = query;
        this.canonicalQuery = query.toCanonicalForm();
        this.context = new TranscriptionContext(new HitNode());
        init();
        this.sql = render(context);
    }

    private String render(TranscriptionContext context){
        //todo could be static
        return "SELECT * FROM "+context.getSearchSpace().toSql()+" WHERE "+new All(context.getCriteria()).toSql()+";"; //todo is ; needed?
    }

    private void init(){
        new RecordVisitor().visit(canonicalQuery, new QueryBuildingCallback(context));
//        new GenericRecordVisitor(new QueryBuildingCallback(context)).visit(query);
    }

    @Override
    public String toSql() {
        return sql;
    }
}
