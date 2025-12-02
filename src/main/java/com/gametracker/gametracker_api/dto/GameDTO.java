package com.gametracker.gametracker_api.dto;

import com.gametracker.gametracker_api.model.Game;
import java.util.Set;
import java.util.stream.Collectors;

public class GameDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Long genreId;
    private String genreNome;
    private Set<Long> platformIds;
    private Set<Long> achievementIds;

    public GameDTO() {}

    public GameDTO(Game game) {
        this.id = game.getId();
        this.titulo = game.getTitulo();
        this.descricao = game.getDescricao();
        
        if (game.getGenre() != null) {
            this.genreId = game.getGenre().getId();
            this.genreNome = game.getGenre().getNome();
        }
        
        this.platformIds = game.getPlatforms().stream()
            .map(platform -> platform.getId())
            .collect(Collectors.toSet());
            
        this.achievementIds = game.getAchievements().stream()
            .map(achievement -> achievement.getId())
            .collect(Collectors.toSet());
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Long getGenreId() { return genreId; }
    public void setGenreId(Long genreId) { this.genreId = genreId; }

    public String getGenreNome() { return genreNome; }
    public void setGenreNome(String genreNome) { this.genreNome = genreNome; }

    public Set<Long> getPlatformIds() { return platformIds; }
    public void setPlatformIds(Set<Long> platformIds) { this.platformIds = platformIds; }

    public Set<Long> getAchievementIds() { return achievementIds; }
    public void setAchievementIds(Set<Long> achievementIds) { this.achievementIds = achievementIds; }
}