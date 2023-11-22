package com.rest.orm.entities.onetomany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
  /*  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id" ,referencedColumnName="id")
    Set<Comment> comments = new HashSet<>();*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="post")
    @JsonManagedReference
    private List<Comment> comments;
}
