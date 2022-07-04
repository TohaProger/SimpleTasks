package com.example.program.Repository;

/**
 * Перечисление сложности требования
 */
public enum ComplexityRequirement {
    sl1( "Высокая"),
    sl2("Средняя"),
    sl3( "Низкая");

    private String text;

    /**
     * конструктор
     * @param text сложность
     */
    private ComplexityRequirement(String text) {
        this.text = text;
    }

    /**
     * получение занчения сложности
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * перепределение метода toString
     * @return  String
     */
    @Override
    public String toString() {
        return this.text;
    }
}
