package com.example.life_insurance_main.PolicyManager;

public class DefineNewRule {
    private String type;
    private String value;

    public DefineNewRule(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DefineNewRule{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
