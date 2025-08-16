package com.example.life_insurance_main.Representative;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class  AppendableObjectOutputStream extends ObjectOutputStream implements Serializable {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException {
    }
}
