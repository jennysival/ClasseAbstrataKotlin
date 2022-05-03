package loja

class Livro(codigoLivro: Int): Produto(codigoLivro) {
    private var autoriaLivro = ""

    override fun cadastrarProduto() {
        println("----------- CADASTRAR LIVRO ----------")
        print("Digite o nome do livro: ")
        nomeProduto = readln()
        print("Digite a autoria do livro $nomeProduto: ")
        autoriaLivro = readln()
        print("Digite o preço do livro $nomeProduto: R$")
        precoProduto = readln().toDouble()
        println("Livro $nomeProduto cadastrado com sucesso!")
        println("--------------------------------------")
    }

    override fun mostrarDetalhesDoItem() {
        println("--------------------------------------")
        println("Livro: $nomeProduto")
        println("Autoria: $autoriaLivro")
        println("Preço:R$$precoProduto")
        println("CDB: $codigoDeBarras")
    }
}