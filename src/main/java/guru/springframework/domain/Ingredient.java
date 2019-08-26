package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne//no cascade, deleting an ingredient does not delete recipe!
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)//is default fetchtype of OneToOne, but intend is clear like this
    private UnitOfMeasure unitOfMeasure;

    public Ingredient() {
    }

    public Ingredient(final String description, final BigDecimal amount, final UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredient(final String description, final BigDecimal amount, final UnitOfMeasure unitOfMeasure, final Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.unitOfMeasure = unitOfMeasure;
    }
}
