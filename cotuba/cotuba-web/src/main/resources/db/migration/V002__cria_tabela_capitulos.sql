CREATE TABLE capitulos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  ordem int NOT NULL,
  nome VARCHAR(255) NOT NULL,
  markdown longtext NOT NULL,
  livro_id bigint NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (livro_id) REFERENCES livros(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
