 ProjetoCrdb


Nome do Projeto<h3>tag
                                          Classificações e Reviews de Disciplinas<h6>


                                                        Funcionalidades<h2>tag

* Item 1 **Cadastrar Usuario**
   * Obs: 1a **Fazer a verificação se já existe outro Usuario com o Mesmo Id definido**
  
* Item 2 **Deletar Usuario** 
   *Obs: 2a **Fazer a verificação por meio de token, pois só se pode deletar o próprio Usuario**
  
* Item3 **Buscar Disciplina com subString**(recebe um subString referente as inicias da palavra desejada)
    *Obs: 3a **retorna todas as disciplinas que possam começa com esse subString**
    *Obs: 3b **Há metodos no repositório que se posam fazer sem fazer linhas de codigo** *Ao meu caso preferir fazer em linhas de Código*
  
 *  Item4 **Adicionar Comentario**(recebe um objeto do tipo comentario e um Id)
 *  Item5 **Deletar Comentario**
  
    *Obs: **A forma de deletar um Comentario é logica, Os Dados do comentario deve permanexer no banco de dados, para analises futuras**(recebe um token String)
    
  Item 6 **Favoritar Disciplina**
    *Obs: **Incrementa em 1 "Um para favoritar e decrementa para 0 "Zero para tirar do favorito""**(recebe um numero inteiro)
    
  Item 7 **Buscar Informações sobre a disciplina**
      Obs: ***retorna todas as informações sobre o comentario da disciplina a propria disciplina e deixa registrado o usuario que comentou
      
                                                 relação de entidade<h4>tag
      **foi interpretado como**
      3 Classses
      1 **Comentario**
      2 **Usuario**
      3 **Disciplina**
      
      @ManyToOne
      @JoinColumn(name = "comentario_disciplina")
	    private Disciplina disciplina;
      De Muitos Comentarios para uma disciplina 
      
      @OneToOne
      @JoinColumn(name = "comentario_usuario")
	    private Usuario usuario;
      de um Usuario para um Comentario = interpretando como para cada Comentario precisa-se de um Usuario
      
      ##Mapear Caminho de Volta ##
      @OneToOne(mappedBy = "usuario")
	    private Comentario comentario;
      
      @ManyToMany
	    @JoinTable(name = "disciplina_Usuario", joinColumns = @JoinColumn(name = "disciplina_Id"), inverseJoinColumns = @JoinColumn(name = "usuario_Email")
       
       *foi utilizado o @JsonIgnore para evitar possiveis ciclos infinitos entre as entidades*
       *A quantidades de minutos em que o Token está válido, é de acordo, há uma pequena pesquisa, que amotra que a quantidade de minutos em que um usuario fica em uma plataforma dessa é de 5 minutos, esse é o tempo que vale o Token de validaçaõ*
       
                                                     ###Finalidade<h3>
                                          
          **Objetivo é fazer uma melhor interação entre Usuarios e as disciplinas, buscando informações para ajudar em uma possivel tomada de descisão*
      
      
      
      
