package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})//bidirectional relations create endless loop in Lombok, so exclude these
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne//No cascade type here, if note is deleted, we don't want the recipe to be deleted as well
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
