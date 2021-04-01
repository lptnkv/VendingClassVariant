package com.example.vendingclassvariant.Models.Fabrics;

import com.example.vendingclassvariant.Models.Coffee;
import com.example.vendingclassvariant.Models.IProduct;

public class CapuccinoFabric implements IFabric {

    @Override
    public IProduct generateProduct() {
        return new Coffee("Capuccino", 30);
    }
}
