package com.amaris.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brand {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "brand")
    private String brand;

}
