package com.importer.importxmlbackend.model;

import com.importer.importxmlbackend.model.dto.GeneratedDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "generated")
public class Generated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float amountValue;

    public static List<Generated> toPersist(List<GeneratedDTO> generatedDTOS) {
        List<Generated> generatedList = new ArrayList<>();
        generatedDTOS.forEach(g ->
                generatedList.add(Generated.builder().amountValue(g.getValor()).build())
        );
        return generatedList;
    }

}
