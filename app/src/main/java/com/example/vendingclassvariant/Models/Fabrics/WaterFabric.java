package com.example.vendingclassvariant.Models.Fabrics;

import com.example.vendingclassvariant.Models.IProduct;
import com.example.vendingclassvariant.Models.Snack;

public class WaterFabric implements IFabric {

    @Override
    public IProduct generateProduct() {
        return new Snack("Water", 20);
    }
}
