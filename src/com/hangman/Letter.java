package com.hangman;

public class Letter {
    private String style;
    private String symbol;
    private boolean clicked;

    public Letter(String symbol) {
        this.symbol = symbol;
        style = "";
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
