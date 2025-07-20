package ads.bcd.sofia.utils.enums;

public enum Menus {

    HELLO("""
             \n
             ▄█        ▄██████▄  ▀█████████▄   ▄█  ███▄▄▄▄      ▄█    █▄     ▄██████▄ \s
            ███       ███    ███   ███    ███ ███  ███▀▀▀██▄   ███    ███   ███    ███\s
            ███       ███    ███   ███    ███ ███▌ ███   ███   ███    ███   ███    ███\s
            ███       ███    ███  ▄███▄▄▄██▀  ███▌ ███   ███  ▄███▄▄▄▄███▄▄ ███    ███\s
            ███       ███    ███ ▀▀███▀▀▀██▄  ███▌ ███   ███ ▀▀███▀▀▀▀███▀  ███    ███\s
            ███       ███    ███   ███    ██▄ ███  ███   ███   ███    ███   ███    ███\s
            ███▌    ▄ ███    ███   ███    ███ ███  ███   ███   ███    ███   ███    ███\s
             ████▄▄██  ▀██████▀  ▄█████████▀  █▀    ▀█   █▀    ███    █▀     ▀██████▀ \s
            \n
                            PRESSIONE [ QUALQUER TECLA ] PARA CONTINUAR
            \n
            \n
            """),

    BYE("""
            \n
             ▄██████▄  ▀█████████▄     ▄████████    ▄█     ▄██████▄     ▄████████ ████████▄   ▄██████▄ \s
            ███    ███   ███    ███   ███    ███   ███    ███    ███   ███    ███ ███   ▀███ ███    ███\s
            ███    ███   ███    ███   ███    ███   ███▌   ███    █▀    ███    ███ ███    ███ ███    ███\s
            ███    ███  ▄███▄▄▄██▀   ▄███▄▄▄▄██▀   ███▌  ▄███          ███    ███ ███    ███ ███    ███\s
            ███    ███ ▀▀███▀▀▀██▄  ▀▀███▀▀▀▀▀     ███▌ ▀▀███ ████▄  ▀███████████ ███    ███ ███    ███\s
            ███    ███   ███    ██▄ ▀███████████   ███    ███    ███   ███    ███ ███    ███ ███    ███\s
            ███    ███   ███    ███   ███    ███   ███    ███    ███   ███    ███ ███   ▄███ ███    ███\s
             ▀██████▀  ▄█████████▀    ███    ███   █▀     ████████▀    ███    █▀  ████████▀   ▀██████▀ \s
            \n
            """),

    MENU("""
                                              ┌──────────────────────────────────────────────────────────────────┐
                                              │                      [ LOBINHO : MAIN MENU ]                     │
                     ┌────────────────────┐   ├──────────────────────────────────────────────────────────────────┤
                     │     [ JOVEM ]      │   │                                                                  │
                     └────────────────────┘   │    ■  [ 1 ] Cadastrar.                                           │
                                              │    ■  [ 2 ] Atualizar.                                           │
                                              │    ■  [ 3 ] Consultar.                                           │
                                              │                                                                  │
                     ┌────────────────────┐   ├──────────────────────────────────────────────────────────────────┤
                     │   [ ATIVIDADES ]   │   │                                                                  │
                     └────────────────────┘   │    ■  [ 4 ] Registrar ( Requisito Comprido ).                    │
                                              │    ■  [ 5 ] Registrar ( Insígnia de Interesse ) para Jovem.      │
                                              │    ■  [ 6 ] Registrar ( Distintivo de Progressão ) para Jovem.   │
                                              │    ■  [ 7 ] Registrar ( Participação em Atividade ).             │
                                              │                                                                  │
                     ┌────────────────────┐   ├──────────────────────────────────────────────────────────────────┤
                     │    [ PÁGINAS ]     │   │                                                                  │
                     └────────────────────┘   │    ■  [ 8 ] Consulta de ( Relatórios ).                          │
                                              │    ■  [ 0 ] Terminar programa.                                   │
                                              │                                                                  │
                                              └──────────────────────────────────────────────────────────────────┘
            """),

        RELATORIOS("""
                                                  ┌────────────────────────────────────────────────────────────────────────┐
                                                  │                       [ LOBINHO : RELATÓRIOS ]                         │
                         ┌────────────────────┐   ├────────────────────────────────────────────────────────────────────────┤
                         │   [ RELATÓRIOS ]   │   │                                                                        │
                         └────────────────────┘   │    ■  [ 1 ] Jovens com determinada ( Especialidade ).                  │
                                                  │    ■  [ 2 ] Jovens com determinada ( Insígnia ).                       │
                                                  │    ■  [ 3 ] Jovens com determinado ( Distintivo ).                     │
                                                  │    ■  [ 4 ] Especialidades, Insígnias e Distintivos de um Jovem.       │
                                                  │    ■  [ 5 ] Jovens Aptos ao ( Cruzeiro do Sul ).                       │
                                                  │                                                                        │
                                                  ├────────────────────────────────────────────────────────────────────────┤
                         ┌────────────────────┐   │                                                                        │
                         │   [ CONSULTAS ]    │   │    ■  [ 6 ] Consultar ( Jovens ).                                      │
                         └────────────────────┘   │    ■  [ 7 ] Consultar ( Responsáveis ).                                │
                                                  │    ■  [ 8 ] Consultar ( Vínculos ).                                    │
                                                  │    ■  [ 9 ] Consultar ( Acampadas ).                                   │
                                                  │    ■  [ 10 ] Consultar ( Noites de Acampada ).                         │
                                                  │                                                                        │
                                                  ├────────────────────────────────────────────────────────────────────────┤
                         ┌────────────────────┐   │                                                                        │
                         │ [ ESPECIALIDADES ] │   │    ■  [ 11 ] Consultar ( Especialidades ).                             │
                         └────────────────────┘   │    ■  [ 12 ] Consultar ( Desafios de Especialidade ).                  │
                                                  │    ■  [ 13 ] Consultar ( Desafios Feitos de Especialidade ).           │
                                                  │                                                                        │
                                                  ├────────────────────────────────────────────────────────────────────────┤
                         ┌────────────────────┐   │                                                                        │
                         │   [ INSÍGNIAS ]    │   │    ■  [ 14 ] Consultar ( Insígnias ).                                  │
                         └────────────────────┘   │    ■  [ 15 ] Consultar ( Desafios de Insígnia ).                       │
                                                  │    ■  [ 16 ] Consultar ( Desafios Feitos de Insígnia ).                │
                                                  │                                                                        │
                                                  ├────────────────────────────────────────────────────────────────────────┤
                         ┌────────────────────┐   │                                                                        │
                         │  [ DISTINTIVOS ]   │   │    ■  [ 17 ] Consultar ( Distintivos ).                                │
                         └────────────────────┘   │    ■  [ 18 ] Consultar ( Desafios de Distintivo ).                     │
                                                  │    ■  [ 19 ] Consultar ( Desafios Feitos de Distintivo ).              │
                                                  │                                                                        │
                                                  ├────────────────────────────────────────────────────────────────────────┤
                         ┌────────────────────┐   │                                                                        │
                         │     [ SAÚDE ]      │   │    ■  [ 20 ] Consultar ( Tipos Sanguíneos ).                           │
                         └────────────────────┘   │    ■  [ 21 ] Consultar ( Problemas de Saúde ).                         │
                                                  │    ■  [ 22 ] Consultar ( Saúde dos Jovens ).                           │
                                                  │                                                                        │
                                                  ├────────────────────────────────────────────────────────────────────────┤
                         ┌────────────────────┐   │                                                                        │
                         │    [ PÁGINAS ]     │   │    ■  [ 0 ] Voltar ao ( Menu Principal ).                              │
                         └────────────────────┘   │                                                                        │
                                                  └────────────────────────────────────────────────────────────────────────┘
    """),


    JOVEM_UPDATE("""
                                             ┌───────────────────────────────────────────────────────────────────┐
                                             │              [ ATUALIZAR DADOS CADASTRAIS DE JOVEM ]              │
                     ┌───────────────────┐   ├───────────────────────────────────────────────────────────────────┤
                     │    [ OPÇÕES ]     │   │                                                                   │
                     └───────────────────┘   │    ■  [ 1 ] Atualizar ( Nome ) de Jovem.                          │
                                             │    ■  [ 2 ] Atualizar ( Data de Nascimento ) de Jovem.            │
                                             │    ■  [ 3 ] Atualizar ( Tipo Sanguíneo ) de Jovem.                │
                                             │    ■  [ 4 ] Atualizar ( Responsável ) de Jovem.                   │
                                             │    ■  [ 5 ] Adicionar novo ( Responsável ) à Jovem.               │
                                             │    ■  [ 6 ] Atualizar ( Problema de Saúde ) de Jovem.             │
                                             │    ■  [ 7 ] Adicionar novo ( Problema de Saúde ) à Jovem.         │
                                             │                                                                   │
                     ┌───────────────────┐   ├───────────────────────────────────────────────────────────────────┤
                     │    [ PÁGINAS ]    │   │                                                                   │
                     └───────────────────┘   │    ■  [ 8 ] Selecionar outro ( Jovem ) para editar.               │
                                             │    ■  [ 0 ] Voltar ao ( Menu Principal ).                         │
                                             │                                                                   │
                                             └───────────────────────────────────────────────────────────────────┘
            """),

    SAUDE_UPDATE("""
                                             ┌────────────────────────────────────────────────────────────────────┐
                                             │              [ ATUALIZAR DADOS DE SAÚDE DE UM JOVEM ]              │
                     ┌───────────────────┐   ├────────────────────────────────────────────────────────────────────┤
                     │    [ OPÇÕES ]     │   │                                                                    │
                     └───────────────────┘   │    ■  [ 1 ] Atualizar ( Problema de Saúde ) de Jovem.              │
                                             │    ■  [ 2 ] Atualizar ( Observações ) de Problema de Saúde.        │
                                             │                                                                    │
                     ┌───────────────────┐   ├────────────────────────────────────────────────────────────────────┤
                     │    [ PÁGINAS ]    │   │                                                                    │
                     └───────────────────┘   │    ■  [ 3 ] Selecionar outra ( Saúde ) para editar.                │
                                             │    ■  [ 0 ] Voltar ao ( Menu Principal ).                          │
                                             │                                                                    │
                                             └────────────────────────────────────────────────────────────────────┘
            """),

    INPUT("> ");

    private final String value;

    Menus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
