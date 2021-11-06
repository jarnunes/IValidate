package com.ivalidate.view;

import com.ivalidate.model.cnpj.CnpjValidate;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ManagedBean
public class BeanValidateCnpj {

    private boolean started = false;
    private boolean valid = false;
    private String cnpj;


    public void validate() {
        this.valid = CnpjValidate.validate(this.cnpj);
        this.started = true;
        setMessages();
    }

    private void setMessages() {
        if (this.valid) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CNPJ " + this.cnpj + " é válido.", null));
        } else if (Objects.equals(this.cnpj, "")) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO! Campo obrigatório", null));

        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CNPJ Inválido.", null));
        }
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public String getIcon() {
        if (this.isStarted()) {
            if (this.valid) return "pi pi-check";
            else if (Objects.equals(this.cnpj, "")) return "pi pi-question";
            else return "pi pi-times";
        }
        return "pi pi-question";
    }

    public String getStyle() {
        if (this.isStarted()) {
            if (this.valid) return "ui-button-success";
            else if (Objects.equals(this.cnpj, "")) return "ui-button-secondary";
            else return "ui-button-danger";
        }
        return "ui-button-secondary";
    }
}
