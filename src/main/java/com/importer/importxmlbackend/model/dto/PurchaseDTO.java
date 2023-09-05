package com.importer.importxmlbackend.model.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseDTO {

    private Float valor;

    public PurchaseDTO(Float valor) {
        this.valor = valor;
    }

    @XmlElement
    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
