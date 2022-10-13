package com.example.program.Repository;

/**
 * Перечисления типа требования
 */
public enum TypeRequirement {
    Func( "Функциональные"),
    ReqInt("Требования к интерфейсам"),
    Func1( "Производительность"),
    ReqInt1("Ограничения"),
    Func2( "Технологические требования"),
    ReqInt2("Требования качества"),
    Func3( "Требования эргономики");
    private final String text;
    TypeRequirement(String text) {
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