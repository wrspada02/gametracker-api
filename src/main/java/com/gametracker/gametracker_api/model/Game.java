package com.gametracker.gametracker_api.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @JsonIgnore
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private final Set<Achievement> achievements = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "game_platform",
        joinColumns = @JoinColumn(name = "game_id"),
        inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private final Set<Platform> platforms = new HashSet<>();

    public Game() {}

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Genre getGenre() { return genre; }
    public Set<Achievement> getAchievements() { return achievements; }
    public Set<Platform> getPlatforms() { return platforms; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setGenre(Genre genre) { this.genre = genre; }

    // JSON Properties that return only IDs
    @JsonProperty("genreId")
    public Long getGenreId() {
        return genre != null ? genre.getId() : null;
    }

    @JsonProperty("achievements")
    public Set<Long> getAchievementIds() {
        return achievements.stream().map(Achievement::getId).collect(Collectors.toSet());
    }

    @JsonProperty("platforms")
    public Set<Long> getPlatformIds() {
        return platforms.stream().map(Platform::getId).collect(Collectors.toSet());
    }
}
