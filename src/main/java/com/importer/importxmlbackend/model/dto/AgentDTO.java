package com.importer.importxmlbackend.model.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class AgentDTO {
    private Long codigo;

    private Date data;

    private List<RegionDTO> regiao;

    public AgentDTO(Long codigo, Date data, List<RegionDTO> regiao) {
        this.codigo = codigo;
        this.data = data;
        this.regiao = regiao;
    }

    @XmlElement
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @XmlElement
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @XmlElement
    public List<RegionDTO> getRegiao() {
        return regiao;
    }

    public void setRegiao(List<RegionDTO> regiao) {
        this.regiao = regiao;
    }
}
