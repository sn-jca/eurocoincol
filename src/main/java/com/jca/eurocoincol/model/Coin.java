package com.jca.eurocoincol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Coin {

    @Id
    @GeneratedValue
    private int id;

    private String country;

    private double value;

    private int year;

    private String description;

    private boolean isCommemorative;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    /*@JsonIgnore
    @ManyToOne
    private Post post;*/

}
