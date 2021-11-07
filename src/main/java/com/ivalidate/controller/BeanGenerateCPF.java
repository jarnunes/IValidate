package com.ivalidate.controller;

import com.ivalidate.model.cpf.CpfGenerate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class BeanGenerateCPF extends BeanBase {
    private boolean started = false;
    private String cpf;

    public String getCpf() {
        return cpf;
    }


    public void generate() {
        this.cpf = CpfGenerate.generateCPF();
        this.started = true;
    }


    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void copyClipBoard() {
        super.copy(this.cpf);
    }
}
