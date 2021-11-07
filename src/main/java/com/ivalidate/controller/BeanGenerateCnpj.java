package com.ivalidate.controller;

import com.ivalidate.model.cnpj.CnpjGenerate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class BeanGenerateCnpj extends BeanBase {
    private boolean started = false;
    private String cnpj;

    public String getCpf() {
        return cnpj;
    }


    public void generate() {
        this.cnpj = CnpjGenerate.generate();
        this.started = true;
    }

    public void copyClipboard() {
        super.copy(this.cnpj);
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

}