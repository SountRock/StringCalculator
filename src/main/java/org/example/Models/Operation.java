package org.example.Models;

import java.util.List;

/**
 * Интерфейс для моделей операций
 */
public interface Operation {

    /**
     * Выполнить операцию в указанной позиции
     * @param expression
     * @param positionIndex
     */
    void operation(List<String> expression, int positionIndex);

    /**
     * Проверяет соотвестие операции
     * @param operation
     * @return is this operation
     */
    boolean isThisOperation(String operation);
}
