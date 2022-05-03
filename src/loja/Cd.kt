package loja

class Cd(codigoCD: Int): Produto(codigoCD) {
    private var numeroDeFaixas = 0

    override fun cadastrarProduto() {
        println("------------ CADASTRAR CD ------------")
        print("Digite o nome do CD: ")
        nomeProduto = readln()
        print("Digite o nº de faixas do CD $nomeProduto: ")
        numeroDeFaixas = readln().toInt()
        print("Digite o preço do CD $nomeProduto: R$")
        precoProduto = readln().toDouble()
        println("CD $nomeProduto cadastrado com sucesso!")
        println("--------------------------------------")
    }

    override fun mostrarDetalhesDoItem() {
        println("--------------------------------------")
        println("CD: $nomeProduto")
        println("Faixas: $numeroDeFaixas")
        println("Preço: R$$precoProduto")
        println("CDB: $codigoDeBarras")
    }

}