package com.importer.importxmlbackend.model;

import com.importer.importxmlbackend.model.dto.PurchaseDTO;
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
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float amountValue;

    public static List<Purchase> toPersist(List<PurchaseDTO> purchaseDTOS) {
        List<Purchase> mediumPriceList = new ArrayList<>();
        purchaseDTOS.forEach(g ->
                mediumPriceList.add(Purchase.builder().amountValue(g.getValor()).build())
        );
        return mediumPriceList;
    }

}
