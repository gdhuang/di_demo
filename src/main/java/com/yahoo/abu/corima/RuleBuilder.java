package com.yahoo.abu.corima;

import java.util.Hashtable;

public class RuleBuilder {
    private Hashtable<Cond, Object> ruleTable;
    private Class fromClazz;

    public RuleBuilder setRuleTable(Hashtable<Cond, Object> ruleTable) {
        this.ruleTable = ruleTable;
        return this;
    }

    public RuleBuilder setFromClazz(Class fromClazz) {
        this.fromClazz = fromClazz;
        return this;
    }

    protected void to(Class toClazz) {
        Cond cond = new Cond(this.fromClazz);
        this.ruleTable.put(cond, toClazz);
    }
}
