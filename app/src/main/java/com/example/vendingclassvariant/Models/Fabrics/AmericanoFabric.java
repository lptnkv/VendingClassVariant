package com.example.vendingclassvariant.Models.Fabrics;

import com.example.vendingclassvariant.Models.Coffee;
import com.example.vendingclassvariant.Models.IProduct;

public class AmericanoFabric implements IFabric {

    @Override
    public IProduct generateProduct() {
        return new Coffee("Americano", 30);
    }
}
