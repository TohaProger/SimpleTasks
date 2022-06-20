package com.example.program.Model;

/**
 * Перечисления типа требования
 */
public enum TypeRequirement {
    Funct( "Функциональные"),
    ReqInt("Требования к интерфейсам"),
    Funct1( "Производительность"),
    ReqInt1("Ограничения"),
    Funct2( "Технологические требования"),
    ReqInt2("Требования качества"),
    Funct3( "Требования эргономики");
    private String text;
    private TypeRequirement(String text) {
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
