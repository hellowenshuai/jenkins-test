package com.design;

public class Duck {
    private QuackBehavior quackBehavior;

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }
}
