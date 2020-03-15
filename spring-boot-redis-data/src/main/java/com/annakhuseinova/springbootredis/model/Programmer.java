package com.annakhuseinova.springbootredis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Programmer implements Serializable {

    private int id;
    private String companyName;
    private String name;
}
