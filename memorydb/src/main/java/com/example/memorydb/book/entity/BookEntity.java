package com.example.memorydb.book.entity;

import com.example.memorydb.entity.Entity;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity extends Entity {

    private String name;
    private String category;
    private BigDecimal amount;

}
