package org.example.AnalizeTools;

import java.util.List;

public class CleanerList<T> {
    List<T> list;

    public CleanerList(List<T> list) {
        this.list = list;
    }

    public List<T> clearList(String clearElement){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(clearElement))
                list.remove(clearElement);
        }

        return list;
    }
}
