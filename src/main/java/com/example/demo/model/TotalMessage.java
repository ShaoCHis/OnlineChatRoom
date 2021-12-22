package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * author ShaoCHi
 * Date 2021/12/19 7:16 PM
 * Tongji University
 */

@Entity
@Getter
@Setter
public class TotalMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;

  private Date time;

  private String message;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="user_Id")
  private User user;
}
