package com.proface.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryModel {

    private int id;

    private String name;

    private String iso;
}
