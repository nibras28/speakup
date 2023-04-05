package com.example.proto2;

public class data {
    private String Food;
    private String Allergen;

    public data(String food, String allergen) {
        this.Food = food;
        this.Allergen = allergen;
    }

    public String getFood() {
        return Food;
    }

    public void setFood(String food) {
        Food = food;
    }

    public String getAllergen() {
        return Allergen;
    }

    public void setAllergen(String allergen) {
        Allergen = allergen;
    }
}
