package com.yahoo.abu.corima;

import java.lang.annotation.Annotation;
import java.util.Hashtable;

public class AbstractModule {

    Hashtable<Cond, Object> ruleTable;

    public AbstractModule() {
        this.ruleTable = new Hashtable<Cond, Object>();
    }

    protected void configure() {
    }

    protected RuleBuilder bind(Class clazz) {
        return new RuleBuilder()
                  .setRuleTable(this.ruleTable)
                  .setFromClazz(clazz);
    }
}
