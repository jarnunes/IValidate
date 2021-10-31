package com.ivalidate.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "generateCPF")
public class ManagedBeanGenerateCPF {

    private boolean start = false;
    private String cpf = "000.000.000-00";
    private boolean valid = false;

    public boolean isStart() {
        return start;
    }

    public boolean validate() {
        this.start = true;
        if (this.cpf.length() == 11) return true;
        return false;
    }

    public void generate() {
        this.start = true;
        this.valid = true;
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
        this.valid = false;
        this.cpf = "000.000.000-00";
    }

    public boolean isValid() {
        return this.valid;
    }

    public String getIcon() {
        if (this.start) {
            if (validate()) return "pi pi-check";
            else return "pi pi-times";
        }
        return "pi pi-question";
    }

    public String getStyle() {
        if (this.start) {
            if (validate()) return "ui-button-success";
            else return "ui-button-danger";
        }
        return "ui-button-secondary";
    }

}
