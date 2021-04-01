package com.example.vendingclassvariant.Models;

import com.example.vendingclassvariant.Models.Fabrics.AmericanoFabric;
import com.example.vendingclassvariant.Models.Fabrics.CapuccinoFabric;
import com.example.vendingclassvariant.Models.Fabrics.IFabric;
import com.example.vendingclassvariant.Models.Fabrics.SnickersFabric;
import com.example.vendingclassvariant.Models.Fabrics.TwixFabric;
import com.example.vendingclassvariant.Models.Fabrics.WaterFabric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class Automat {
    public enum AutomatStatus{
        Waiting,
        Client_Choosing,
        Client_Paying,
        Giving_Products
    }
    private int name;
    private AutomatStatus status;
    private TreeMap<IProduct, Integer> snackMenu;

    public Automat(int name) {
        this.name = name;
        this.status = AutomatStatus.Waiting;
        snackMenu = new TreeMap<>();
    }

    public void putProducts(){
        List<IFabric> fabrics = new ArrayList<>(
                Arrays.asList(
                    new AmericanoFabric(),
                    new CapuccinoFabric(),
                    new SnickersFabric(),
                    new TwixFabric(),
                    new WaterFabric()
            ));

        for (int i = 0; i < 30; i++){
            int randomFabricIndex = new Random().nextInt(fabrics.size());

            int innerCount = snackMenu.getOrDefault(fabrics.get(randomFabricIndex).generateProduct(), 0);
            snackMenu.put(fabrics.get(randomFabricIndex).generateProduct(), innerCount+1);
        }
    }

    public IProduct getProduct() {
        List<IProduct> products = new ArrayList<>(snackMenu.keySet());

        int randomProductIndex = new Random().nextInt(products.size());
        if (snackMenu.get(products.get(randomProductIndex)) > 0){
            snackMenu.put(products.get(randomProductIndex),
                    snackMenu.get(products.get(randomProductIndex)) - 1
                    );
            return products.get(randomProductIndex);
        } else {
            return null;
        }
    }

    public AutomatStatus getStatus(){
        return status;
    }

    public void setStatus(AutomatStatus status) {
        this.status = status;
    }

    public int getName() {
        return name;
    }
}
