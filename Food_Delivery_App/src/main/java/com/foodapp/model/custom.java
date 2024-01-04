package com.foodapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class custom {

    private UUID uuid;

}
