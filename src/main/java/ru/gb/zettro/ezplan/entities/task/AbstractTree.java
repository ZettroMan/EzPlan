package ru.gb.zettro.ezplan.entities.task;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractTree {
    private List<AbstractTree> children = new ArrayList<>();
    private AbstractTree parent;

    protected void addChild(AbstractTree child) {
        child.setParent(this);
        children.add(child);
    }

    protected boolean removeChild(AbstractTree child) {
        return children.remove(child);
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }


}
