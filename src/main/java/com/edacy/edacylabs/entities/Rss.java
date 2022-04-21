package com.edacy.edacylabs.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rss {
    private  String title;
    private  String description;
    private  String copyright;
    private  String link;
    Set<Item> items;
}
