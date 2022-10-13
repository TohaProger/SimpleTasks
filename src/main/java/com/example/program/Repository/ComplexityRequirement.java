package com.example.program.Repository;

/**
 * Перечисление сложности требования
 */
public enum ComplexityRequirement {
    sl1("Высокая"),
    sl2("Средняя"),
    sl3("Низкая");

    private final String text;

    /**
     * конструктор
     *
     * @param text сложность
     */
    ComplexityRequirement(String text) {
        this.text = text;
    }

    /**
     * получение значения сложности
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * переопределение метода toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return this.text;
    }
}