package com.example.program.Model;

/**
 * Перечисление приоритета требования
 */
public enum PriorityRequirement {
    pr1( "Высокий"),
    pr2("Средний"),
    pr3( "Низкий");

    private String text;
    private PriorityRequirement(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    @Override
    public String toString() {
        return this.text;
    }
}
