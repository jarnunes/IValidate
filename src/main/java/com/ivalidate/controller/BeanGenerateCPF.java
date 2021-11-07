package com.ivalidate.controller;

import com.ivalidate.model.cpf.CpfGenerate;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class BeanGenerateCPF extends BeanBase {

    public void generate() {
        this.setIdentity(CpfGenerate.generateCPF());
        this.setStarted(true);
    }

    public void copyClipBoard() {
        super.copy(this.getIdentity());
    }
}
