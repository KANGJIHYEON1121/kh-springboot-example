package com.jeus.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok annotation
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CheckBoxLabelValue {
    private String label;
    private String value;
}
