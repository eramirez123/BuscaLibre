Feature: Navegar a buscaLibre colombia y validar el funcionamiento de la página
    para validar el funcionamiento de la pagina
    como persona que no se ha logueado
    quiero realizar la consulta de los libros

    Background: Go to buscalibre page
        Given go to buscalibre page

    @ResultadosEncontrados
    Scenario Outline: validate book search with results
        When i search the book <bookName>
        Then validate that any search results are found

        Examples:
            | bookName                              |
            | El coronel no tiene quien le escriba  |
            | cien años de soledad                  |
            | la metamorfosis                       |
            | la isla del tesoro                    |
            | fundamentos de java                   |



    @ResultadosNoEncontrados
    Scenario Outline: Validate book search without results
        When i search the book <bookName>
        Then validate that no search results are found


        Examples:
            | bookName                              |
            | selenium con java                     |
            | Un libro que no debería existir       |
            | la metamorfosis                       |


    @ResultadosPorAutor @ResultadosEncontrados
    Scenario Outline: Validate that the search is filtered by author and that results are found
        When i search the book <bookName>
        Then validate that there are results for the author <author>


        Examples:
            | bookName                              | author            |
            | El coronel no tiene quien le escriba  | Juliana Borrero   |
            | la metamorfosis                       | Paul Pen          |
            | la isla del tesoro                    | Disney            |


    @PrecioAleatorio
    Scenario Outline: validate that the price of the search and the detail price match
        When i search the book <bookName>


        Examples:
            | bookName              |
            | Selenium Webdriver    |
            | Selenium Webdriver    |
            | Selenium Webdriver    |