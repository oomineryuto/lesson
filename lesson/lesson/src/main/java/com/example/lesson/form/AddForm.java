package com.example.lesson.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class AddForm {
    @NotEmpty
    @Length(min=1,max=50)
    private String name;
    @NotNull
    @Range (min =0,max = Integer.MAX_VALUE)
    private Integer price;
}
