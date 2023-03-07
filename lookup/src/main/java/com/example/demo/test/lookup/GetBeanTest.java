package com.example.demo.test.lookup;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class GetBeanTest {

    public void showMe() {
        this.getBean().showMe();
    }

    @Lookup()
    public abstract User getBean();


}
