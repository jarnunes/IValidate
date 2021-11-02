package com.ivalidate.view;

import com.ivalidate.model.cpf.CPFGenerate;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


@Named
@ManagedBean
@RequestScoped
public class BeanGenerateCPF {
    private boolean started = false;
    private String cpf;

    public String getCpf() {
        return cpf;
    }


    public void generate() {
        this.cpf = CPFGenerate.generateCPF();
        this.started = true;
    }


    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    /*
    public String getIcon() {
        if (this.started) {
            if (this.valid) return "pi pi-check";
            else if (this.cpf == "") return "pi pi-question";
            else return "pi pi-times";
        }
        return "pi pi-question";
    }

    public String getStyle() {
        if (this.started) {
            if (this.valid) return "ui-button-success";
            else if (this.cpf == "") return "ui-button-secondary";
            else return "ui-button-danger";
        }
        return "ui-button-secondary";
    }*/
}
