package com.ivalidate.view;

import com.ivalidate.model.CopyClipboard;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class BeanBase {

    protected void copy(String value) {
        CopyClipboard.copy(value);
    }
}
