package com.importer.importxmlbackend.model;

import com.importer.importxmlbackend.util.RegionCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_code")
    private RegionCode regionCode;

    private Long generatedId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "region_generate",
            joinColumns = @JoinColumn(name = "generated_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Generated> generated;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "region_purchase",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Purchase> purchase;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "region_medium_price",
            joinColumns = @JoinColumn(name = "medium_price_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<MediumPrice> mediumPrice;

}
