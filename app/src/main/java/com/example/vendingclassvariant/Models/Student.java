package com.example.vendingclassvariant.Models;

import android.os.AsyncTask;

import androidx.loader.content.AsyncTaskLoader;

import com.example.vendingclassvariant.MainActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Student {
    private final String name;
    private List<IProduct> cart;
    private final int cartCount;
    private Automat automat;

    public Student(int name, int cartCount, Automat automat) {
        this.name = "Студент №" + name;
        this.cartCount = cartCount;
        this.automat = automat;
    }

    public void chooseProduct() throws InterruptedException{
        while (cart.size() != cartCount){
            IProduct product = automat.getProduct();
            if(product != null){
                TimeUnit.SECONDS.sleep(1);
                cart.add(product);
            }
        }
    }

    public double CartCost(){
        double finalCost = 0;
        for (IProduct product : cart){
            finalCost += product.getCost();
        }
        return finalCost;
    }

    public void PayForCart() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    public String getName() {
        return name;
    }

    public List<IProduct> getCart() {
        return cart;
    }

    class StudentTask extends AsyncTask<Void, Void, Void> {
        final Student student;
        final Automat automat;

        public StudentTask(Student student, Automat automat) {
            this.student = student;
            this.automat = automat;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            synchronized (automat){
                publishProgress();
                automat.setStatus(Automat.AutomatStatus.Client_Choosing);
                publishProgress();
                try {
                    student.chooseProduct();
                    publishProgress();
                    automat.setStatus(Automat.AutomatStatus.Client_Paying);
                    publishProgress();
                    automat.
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values){
            MainActivity.getInstance().updateData(automat, student);
        }
    }
}