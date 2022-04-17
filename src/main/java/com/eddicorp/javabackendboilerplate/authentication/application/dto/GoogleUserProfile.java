package com.eddicorp.javabackendboilerplate.authentication.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoogleUserProfile {
      private String id;
      private String email;
      private String verifiedEmail;
      private String name;
      private String givenName;
      private String familyName;
      private String picture;
      private String locale;
}
