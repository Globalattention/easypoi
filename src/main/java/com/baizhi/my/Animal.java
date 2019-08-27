package com.baizhi.my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* @author miaoyi
*
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors (chain = true)
public class Animal {
    private String id;
    private String name;

}
