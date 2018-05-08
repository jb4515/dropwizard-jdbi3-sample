package unicorn.model;


import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * Created by jitesh-kumar on 7/5/18.
 */

@Data
@ToString
@NoArgsConstructor
public class Employee {

  private Integer id;

  @NotBlank
  @Length(min = 2, max = 255)
  private String firstname;

  @NotBlank
  @Length(min = 2, max = 255)
  private String lastname;

  @Pattern(regexp = ".+@.+\\.[a-z]+")
  private String email;

  public Employee(final Integer id, final String firstname, final String lastname, final String email) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
  }
}