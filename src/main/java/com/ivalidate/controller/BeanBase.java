package com.ivalidate.controller;

import com.ivalidate.model.CopyClipboard;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



@Getter
@Setter
@ManagedBean
@RequestScoped
public class BeanBase {
    private boolean started = false;
    private String identity;

    protected void copy(String value) {
        CopyClipboard.copy(value);
    }
}
