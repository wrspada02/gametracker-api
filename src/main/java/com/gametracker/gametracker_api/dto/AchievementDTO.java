package com.gametracker.gametracker_api.dto;

import com.gametracker.gametracker_api.model.Achievement;

public class AchievementDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Long gameId;
    private String gameTitulo;

    public AchievementDTO() {}

    public AchievementDTO(Achievement achievement) {
        this.id = achievement.getId();
        this.nome = achievement.getNome();
        this.descricao = achievement.getDescricao();
        
        if (achievement.getGame() != null) {
            this.gameId = achievement.getGame().getId();
            this.gameTitulo = achievement.getGame().getTitulo();
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Long getGameId() { return gameId; }
    public void setGameId(Long gameId) { this.gameId = gameId; }

    public String getGameTitulo() { return gameTitulo; }
    public void setGameTitulo(String gameTitulo) { this.gameTitulo = gameTitulo; }
}