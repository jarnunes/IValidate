package com.ivalidate.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "generateCPF")
public class ManagedBeanGenerateCPF {

    private boolean start = false;
    private String cpf = "000.000.000-00";


    public boolean isStart() {
        return start;
    }

    public void generate() {
        this.start = true;
        this.cpf = "030.302.892-06";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void restart() {
        this.start = false;
        this.cpf = "000.000.000-00";
    }

}
