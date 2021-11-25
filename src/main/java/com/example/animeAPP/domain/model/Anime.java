package com.example.animeAPP.domain.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID animeID;
    public String name;
    public String description;
    public String type;
    public int year_release;
    public String imageurl;
}
