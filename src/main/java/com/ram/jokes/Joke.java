package com.ram.jokes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.io.Reader;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Data
@Entity
public class Joke {
    @JsonProperty("ID")
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer id;
    @JsonProperty("Question")
    private String question;
    @JsonProperty("Answer")
    @Column(columnDefinition = "TEXT")
    private String answer;
}
