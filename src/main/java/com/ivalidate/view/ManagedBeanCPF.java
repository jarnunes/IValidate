package com.ivalidate.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "validateCPF")
public class ManagedBeanCPF {
    private boolean start = false;
    private String cpf = "010.110.221-06";

    public boolean isStart() {
        return start;
    }

    public void setStart() {
        this.start = true;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void restart() {
        this.start = false;
    }
}
