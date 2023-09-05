package com.importer.importxmlbackend.model;

import com.importer.importxmlbackend.model.dto.MediumPriceDTO;
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
@Table(name = "medium_price")
public class MediumPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float amountValue;

    public static List<MediumPrice> toPersist(List<MediumPriceDTO> generatedPriceDTOS) {
        List<MediumPrice> mediumPriceList = new ArrayList<>();
        generatedPriceDTOS.forEach(g ->
                mediumPriceList.add(MediumPrice.builder().amountValue(g.getValor()).build())
        );
        return mediumPriceList;
    }

}
