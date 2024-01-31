package org.example.Models;

import java.util.List;

public interface Operation {

    void operation(List<String> expression, int positionIndex);

    boolean isThisOperation(String operation);
}
