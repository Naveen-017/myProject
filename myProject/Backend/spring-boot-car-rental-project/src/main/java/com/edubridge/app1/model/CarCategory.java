package com.edubridge.app1.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="car_category")
@Getter
@Setter
public class CarCategory {
		
   @Id
   @GeneratedValue
   private Long categoryId;
   private String categoryName;
   
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carCategory")
    private Set<Car> cars;


}
