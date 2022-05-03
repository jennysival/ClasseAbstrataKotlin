package loja

abstract class Produto(codigo: Int) {
    var codigoDeBarras = codigo
    protected var nomeProduto = ""
    protected var precoProduto = 0.0

    open fun cadastrarProduto(){
        println("---------- CADASTRAR PRODUTO ---------")
        print("Digite o nome do produto: ")
        nomeProduto = readln()
        print("Digite o preço do produto $nomeProduto: R$")
        precoProduto = readln().toDouble()
    }

    abstract fun mostrarDetalhesDoItem()

    override fun equals(other: Any?): Boolean{
        return codigoDeBarras == other
    }


}