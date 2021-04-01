package com.example.vendingclassvariant.Models.Fabrics;

import com.example.vendingclassvariant.Models.IProduct;
import com.example.vendingclassvariant.Models.Snack;

public class SnickersFabric implements IFabric {
    @Override
    public IProduct generateProduct() {
        return new Snack("Snickers", 55);
    }
}
