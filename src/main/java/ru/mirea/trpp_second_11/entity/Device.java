package ru.mirea.trpp_second_11.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/** Сущность устройства. */
@Getter
@Setter
@ToString
public class Device {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Название устройства. */
    @JsonProperty("name")
    @CsvBindByName(column = "name")
    private String name;
    /** Компания-изготовитель. */
    @JsonProperty("brand")
    @CsvBindByName(column = "brand")
    private String brand;
    /** Цена. */
    @JsonProperty("price")
    @CsvBindByName(column = "price")
    private BigDecimal price;
    /** Дата выхода. */
    @JsonProperty("created")
    @CsvBindByName(column = "created")
    private String created;

}
