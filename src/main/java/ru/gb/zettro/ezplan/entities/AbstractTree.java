package ru.gb.zettro.ezplan.entities;

import lombok.Data;

import java.util.List;

@Data
public abstract class AbstractTree {
    List<AbstractTree> children;
    AbstractTree parent;

    public void addChild(AbstractTree t) {
        t.setParent(this);
        children.add(t);
    }

    public List<AbstractTree> getChildren() {
        return children;
    }

    public AbstractTree getParent() {
        return parent;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children == null;
    }

}
