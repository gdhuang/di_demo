package com.yahoo.abu.corima;

public class Guice {

    public static Injector createInjector(AbstractModule module) {
        module.configure();
        return new Injector(module.ruleTable);
    }

}
