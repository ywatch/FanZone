package com.example.api1.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posts {
  private int id;
  private String username;
  private String datep;
  private String title;
  private String PathPic;
}
