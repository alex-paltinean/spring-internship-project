package com.accenture.springcore.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Job extends BaseEntity {
    @Column
    private String name;
    @Column
    private Integer level;

    public Person getPerson() {
        return null;
    }

}
