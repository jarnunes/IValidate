package com.ivalidate.controller;

import com.ivalidate.model.cnpj.CnpjGenerate;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class BeanGenerateCnpj extends BeanBase {


    public void generate() {
        this.setIdentity(CnpjGenerate.generate());
        this.setStarted(true);
    }

    public void copyClipboard() {
        super.copy(this.getIdentity());
    }


}