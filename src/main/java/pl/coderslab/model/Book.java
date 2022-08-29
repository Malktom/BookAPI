package pl.coderslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotBlank
    private String isbn;
    @Length(min=3)
    private String title;
    private String author;
    private String publisher;
    private String type;


    @Override
    public String toString() {
        return "id:" +this.id +" "+"\n"+
                "isbn: " +this.isbn +" "+"\n"+
                "title: " +this.title + " " +"\n"+
                "author: " + this.author + " " +"\n"+
                "publisher: " +this.publisher + " "+"\n"+
                "type: " +this.type;
    }
}
