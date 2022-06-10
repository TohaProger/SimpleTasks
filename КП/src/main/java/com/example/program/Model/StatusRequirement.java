package com.example.program.Model;

/**
 * Перечисления статуса проекта
 */
public enum StatusRequirement {
    st1( "Предложено"),
    st2("Одобрено"),
    st3( "Утверждено"),
    st4("Реализовано"),
    st5( "Верифицировано");
    private String text;
    private StatusRequirement(String text) {
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
