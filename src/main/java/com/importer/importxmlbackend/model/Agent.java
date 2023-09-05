package com.importer.importxmlbackend.model;

import com.importer.importxmlbackend.model.dto.AgentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "agent_region",
            joinColumns = @JoinColumn(name = "region_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Region> regions;

    public static Agent toPersist(AgentDTO agent) {
        return Agent.builder()
                .id(agent.getCodigo())
                .date(agent.getData())
                .regions(Region.toPersist(agent.getRegiao()))
                .build();
    }
}
