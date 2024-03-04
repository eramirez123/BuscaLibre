Feature: Navegar a buscaLibre colombia y validar el funcionamiento de la página
    para validar el funcionamiento de la pagina
    como persona que no se ha logueado
    quiero realizar la consulta de los libros

    Scenario Outline: validate book search with results
        Given go to buscalibre page
        When i search the book <bookName>
        Then validate that any search results are found

        Examples:
            | bookName                              |
            | El coronel no tiene quien le escriba  |
            | cien años de soledad                  |
            | la metamorfosis                       |
            | la isla del tesoro                    |
            | fundamentos de java                   |

