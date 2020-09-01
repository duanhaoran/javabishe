package com.hhs.business.text.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class text {
    @Id
    @Column(name = "id" )
    private String id;
    private String name;
    private Integer age;
    private String bir;
}
