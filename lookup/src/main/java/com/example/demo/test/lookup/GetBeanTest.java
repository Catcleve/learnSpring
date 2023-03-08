package com.example.demo.test.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class GetBeanTest {

    public void showMe() {
        this.getBean().showMe();
    }

    @Lookup("1234")
    public abstract User getBean();

}
