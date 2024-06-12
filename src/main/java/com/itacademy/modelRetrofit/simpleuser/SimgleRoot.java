package com.itacademy.modelRetrofit.simpleuser;

import com.itacademy.modelRetrofit.listusers.Support123;
import com.itacademy.modelRetrofit.listusers.Data;

public class SimgleRoot {

    private Data data;
    private Support123 support;

    public SimgleRoot(Data data, Support123 support) {
        this.data = data;
        this.support = support;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support123 getSupport() {
        return support;
    }

    public void setSupport(Support123 support) {
        this.support = support;
    }
}
