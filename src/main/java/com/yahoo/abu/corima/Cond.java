package com.yahoo.abu.corima;

public class Cond {
    private Class clazz;

    public Cond(Class clazz) {
      this.clazz = clazz;
    }

    public Class getClazz() { return clazz; }

    @Override
    public int hashCode() { return clazz.hashCode(); }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Cond)) return false;
      Cond pairo = (Cond) o;
      return this.clazz.equals(pairo.getClazz());
    }

  }