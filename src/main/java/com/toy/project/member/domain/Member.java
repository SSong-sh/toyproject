package com.toy.project.member.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    private long member_num; //고객 아이디 번호 pk

    @Column(name = "id", nullable = false)
    private String id; //고객 아이디

    @Column(name = "password", nullable = false)
    private String password; // 비밀번호

    @Column(name = "name", nullable = false)
    private String name; //이름

    @Column(name = "zip_code", nullable = false)
    private String zip_code;// 우편번호

    @Column(name = "address", nullable = false)
    private String address; // 주소

    @Column(name = "phone", nullable = false)
    private String phone; // 전화번호

    @Column(name = "email", nullable = false)
    private String email;// 이메일

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "join_date")
    private Date join_date = new Date(); //등록일

    @ColumnDefault("1")
    @Column(name = "status")
    private int status = 1; // 회원상태 탈퇴시 0 활동시 1

    @ColumnDefault("0")
    @Column(name = "card")
    private int card = 0;
}
