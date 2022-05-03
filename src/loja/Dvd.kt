package loja

class Dvd(codigoDvd: Int): Produto(codigoDvd) {
    private var duracaoDvdMin = 0

    override fun cadastrarProduto() {
        println("----------- CADASTRAR DVD ------------")
        print("Digite o nome do DVD: ")
        nomeProduto = readln()
        print("Digite a duração(min) do DVD $nomeProduto: ")
        duracaoDvdMin = readln().toInt()
        print("Digite o preço do DVD $nomeProduto: R$")
        precoProduto = readln().toDouble()
        println("CD $nomeProduto cadastrado com sucesso!")
        println("--------------------------------------")
    }

    override fun mostrarDetalhesDoItem() {
        println("--------------------------------------")
        println("DVD: $nomeProduto")
        println("Duração: $duracaoDvdMin minutos")
        println("Preço: $precoProduto")
        println("CDB: $codigoDeBarras")
    }
}