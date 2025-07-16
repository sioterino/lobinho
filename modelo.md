```mermaid
erDiagram
	Jovem {
		INT idJovem PK ""  
		VARCHAR nome  ""  
		DATETIME dataNascimento  ""  
		VARCHAR telefone  ""  
		VARCHAR email  ""  
		INT idTipoSanguineo FK ""  
	}
	Responsavel {
		INT idResponsavel PK ""  
		VARCHAR nome  ""  
		VARCHAR telefone  ""  
		VARCHAR email  ""  
	}
	Vinculo {
		INT idJovem FK ""  
		INT idResponsavel FK ""  
	}
	TipoSanguineo {
		INT idTipoSanguineo PK ""  
		VARCHAR tipo  ""  
	}
	Saude {
		INT idJovem FK ""  
		INT idProblemaSaude FK ""  
	}
	ProblemaSaude {
		INT idProblemaSaude PK ""  
		VARCHAR tipoProblema  ""  
		VARCHAR descricao  ""  
	}
	Acampamento {
		INT idAcampamento PK ""  
		VARCHAR nome  ""  
		DATETIME data  ""  
	}
	NoiteAcampada {
		INT idAcampamento FK ""  
		INT idJovem FK ""  
	}
	Insignia {
		INT idInsignia PK ""  
		VARCHAR nome  ""  
	}
	DesafioInsignia {
		INT idDesafio PK ""  
		VARCHAR nome  ""  
		INT idInsignia FK ""  
	}
	DesafioInsigniaFeita {
		INT idDesafio FK ""  
		INT idJovem FK ""  
		DATETIME data  ""  
	}
	Especialidade {
		INT idEspecialidade PK ""  
		VARCHAR nome  ""  
		INT idAreaDeConhecimento FK ""  
	}
	DesafioEspecialidade {
		INT idDesafio PK ""  
		VARCHAR nome  ""  
		INT idEspecialidade FK ""  
	}
	DesafioEspecialidadeFeita {
		INT idDesafio FK ""  
		INT idJovem FK ""  
		DATETIME data  ""  
	}
	AreaDeConhecimento {
		INT idAreaDeConhecimento PK ""  
		VARCHAR nome  ""  
	}
	Distintivo {
		INT idDistintivo PK ""  
		VARCHAR nome  ""  
	}
	DesafioDistintivo {
		INT idDesafioDistintivo PK ""  
		VARCHAR descricao  ""  
		INT idDistintivo FK ""  
	}
	DesafioDistintivoFeita {
		INT idDesafioDistintivo FK ""  
		INT idJovem FK ""  
		DATETIME dataInicio  ""  
		DATETIME dataFim  ""  
	}

	Jovem||--o{Vinculo:"tem"
	Responsavel||--o{Vinculo:"responsável por"
	TipoSanguineo||--o{Jovem:"tem"
	ProblemaSaude||--o{Saude:"descrito por"
	Jovem||--o{Saude:"tem"
	Acampamento||--o{NoiteAcampada:"registrado em"
	Jovem||--o{NoiteAcampada:"participou"
	Insignia||--o{DesafioInsignia:"composta por"
	DesafioInsignia||--o{DesafioInsigniaFeita:"completada por"
	Jovem||--o{DesafioInsigniaFeita:"completou"
	Especialidade||--o{DesafioEspecialidade:"contém"
	DesafioEspecialidade||--o{DesafioEspecialidadeFeita:"realizada por"
	Jovem||--o{DesafioEspecialidadeFeita:"participou"
	AreaDeConhecimento||--o{Especialidade:"inclui"
	Distintivo||--o{DesafioDistintivo:"possui"
	DesafioDistintivo||--o{DesafioDistintivoFeita:"tentado por"
	Jovem||--o{DesafioDistintivoFeita:"tentou"

``` 