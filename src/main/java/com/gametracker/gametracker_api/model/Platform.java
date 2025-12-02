package com.gametracker.gametracker_api.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "platforms")
    private final Set<Game> games = new HashSet<>();

    public Platform() {}

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Set<Game> getGames() { return games; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }

    @JsonProperty("games")
    public Set<Long> getGameIds() {
        return games.stream().map(Game::getId).collect(Collectors.toSet());
    }
}
