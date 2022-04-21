package com.edacy.edacylabs.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "TD_Item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "pubDate")
    private String pubDate;
    @Column(name = "description", length = 1500)
    private String description;
    @Column(name = "link")
    private String link;
    @Column(name = "mediaContent")
    private String mediaContent;



}
