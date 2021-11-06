package com.ivalidate.view;

import com.ivalidate.model.cpf.CpfValidate;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Objects;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class BeanValidateCPF {
    private boolean started = false;
    private String cpf;
    private boolean valid = false;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void validate() {
        this.valid = CpfValidate.validate(this.cpf);
        this.started = true;
        setMessages();
    }

    private void setMessages() {
        if (this.valid) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CPF " + this.cpf + " é válido.", null));
        } else if (Objects.equals(this.cpf, "")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO! Campo obrigatório", null));

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido.", null));

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
            else if (Objects.equals(this.cpf, "")) return "pi pi-question";
            else return "pi pi-times";
        }
        return "pi pi-question";
    }

    public String getStyle() {
        if (this.isStarted()) {
            if (this.valid) return "ui-button-success";
            else if (Objects.equals(this.cpf, "")) return "ui-button-secondary";
            else return "ui-button-danger";
        }
        return "ui-button-secondary";
    }
}
