package rats.BM.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name = "user")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid")
    private Long sid;

    @Column(name = "userID")
    private String userID;

    @Column(name = "userPW")
    private String userPW;

    @Column(name = "userNAME")
    private String userName;

    @Column(name = "userSTID")
    private Integer userSTID;
}
