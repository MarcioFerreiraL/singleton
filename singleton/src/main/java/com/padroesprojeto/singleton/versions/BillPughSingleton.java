package com.padroesprojeto.singleton;
// tecnica Bill Pugh, utiliza uma classe interna
public class BillPughSingleton {
    private BillPughSingleton() {
        return;
    }

    private static class SingletonHelper {
        private static final BillPughSingleton BILL_PUGH_SINGLETON_INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.BILL_PUGH_SINGLETON_INSTANCE;
    }
}