package pointman.springmvc_db.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//jpa ORM(Object Relation Mapping)

@Getter @Setter
@Entity
public class Member {
    @Id  //PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //시퀀스 설정
    private Long id;

    //@Column(name = "username")
    private String name;

}
