package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * author ShaoCHi
 * Date 2021/12/19 7:05 PM
 * Tongji University
 */

@Entity
@Getter
@Setter
public class Friends {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer Id;

  //firstUser对应消息的发送者
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "first_user")
  private User firstUser;

  //secondFriend对应消息的接受者
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="second_user")
  private User secondUser;
}