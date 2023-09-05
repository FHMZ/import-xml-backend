package com.importer.importxmlbackend.model.dto;

import com.importer.importxmlbackend.util.RegionCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class RegionDTO {

    private RegionCode sigla;

    private List<GeneratedDTO> geracao;

    private List<PurchaseDTO> compra;

    private List<MediumPriceDTO> precoMedio;

    public RegionDTO(RegionCode sigla, List<GeneratedDTO> geracao,
                     List<PurchaseDTO> compra, List<MediumPriceDTO> precoMedio) {
        this.sigla = sigla;
        this.geracao = geracao;
        this.compra = compra;
        this.precoMedio = precoMedio;
    }

    @XmlElement
    public RegionCode getSigla() {
        return sigla;
    }

    public void setSigla(RegionCode sigla) {
        this.sigla = sigla;
    }

    @XmlElement
    public List<GeneratedDTO> getGeracao() {
        return geracao;
    }

    public void setGeracao(List<GeneratedDTO> geracao) {
        this.geracao = geracao;
    }

    @XmlElement
    public List<PurchaseDTO> getCompra() {
        return compra;
    }

    public void setCompra(List<PurchaseDTO> compra) {
        this.compra = compra;
    }

    @XmlElement
    public List<MediumPriceDTO> getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(List<MediumPriceDTO> precoMedio) {
        this.precoMedio = precoMedio;
    }
}
