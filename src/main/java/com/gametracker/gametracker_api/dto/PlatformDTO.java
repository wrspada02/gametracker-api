package com.gametracker.gametracker_api.dto;

import com.gametracker.gametracker_api.model.Platform;
import java.util.Set;
import java.util.stream.Collectors;

public class PlatformDTO {
    private Long id;
    private String nome;
    private Set<Long> gameIds;

    public PlatformDTO() {}

    public PlatformDTO(Platform platform) {
        this.id = platform.getId();
        this.nome = platform.getNome();
        this.gameIds = platform.getGames().stream()
            .map(game -> game.getId())
            .collect(Collectors.toSet());
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Set<Long> getGameIds() { return gameIds; }
    public void setGameIds(Set<Long> gameIds) { this.gameIds = gameIds; }
}