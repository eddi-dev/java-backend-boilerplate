package com.eddicorp.javabackendboilerplate.user.infrastructure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "default_user",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_default_user_uid", columnNames = "uid"),
                @UniqueConstraint(name = "uq_default_user_email", columnNames = "email"),
                @UniqueConstraint(name = "uq_default_user_name", columnNames = "display_name"),
        }
)
public class BoilerplateUserEntity {

    @Id
    @GeneratedValue
    private Long id = null;

    @Column(name = "uid", nullable = false)
    private String uid;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "display_name", nullable = false)
    private String displayName;
}
