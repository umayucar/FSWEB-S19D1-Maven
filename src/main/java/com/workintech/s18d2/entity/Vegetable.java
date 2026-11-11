package com.workintech.s18d2.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="vegetable")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @Column(name = "is_grow_on_tree")
    private Boolean grownOnTree;

    public boolean isGrownOnTree() {
        return Boolean.TRUE.equals(grownOnTree);
    }
}
