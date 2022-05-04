package loja

import kotlin.system.exitProcess

class Loja {
    private val listaDeProdutosCadastrados = ArrayList<Produto>(5)
    private var opcMenu = 0
        set(value) {
            if(value in 1..3){
                field = value
            }
            else{
                opcaoInvalida()
            }
        }
    private var code = 0

    init{
        println("Seja bem vinde ao estoque da loja")
    }

    fun menuInicial(){
        println("---------------------------------")
        println("O que deseja fazer?")
        println("[1] Cadastrar Produtos")
        println("[2] Exibir produtos cadastrados")
        println("[3] Buscar produto")
        println("[4] Sair")
        print("Digite o nº da opção desejada: ")
        when(readln().toInt()){
            1 -> menuCadastro()
            2 -> exibirLista()
            3 -> buscarProdutoNaLista()
            4 -> exitProcess(0)
            else -> {
                println("Inválido")
                menuInicial()
            }
        }
    }

    private fun menuCadastro(){
        println("Cadastrar produtos no estoque da loja")
        println("-------------------------------------")
        for(i in 1..5){
            println("Escolha a categoria do ${i}º produto: ")
            println("[1] Livro")
            println("[2] CD")
            println("[3] DVD")
            print("Digite o nº da opção escolhida: ")
            selecionarOpcaoMenu()
            when(opcMenu){
                1 -> {
                    cadastroCodigoDeBarras()
                    verificaEqualsTrue()
                    val novoLivro = Livro(code)
                    novoLivro.cadastrarProduto()
                    listaDeProdutosCadastrados.add(novoLivro)
                }
                2 -> {
                    cadastroCodigoDeBarras()
                    verificaEqualsTrue()
                    val novoCD = Cd(code)
                    novoCD.cadastrarProduto()
                    listaDeProdutosCadastrados.add(novoCD)
                }
                3 -> {
                    cadastroCodigoDeBarras()
                    verificaEqualsTrue()
                    val novoDVD = Dvd(code)
                    novoDVD.cadastrarProduto()
                    listaDeProdutosCadastrados.add(novoDVD)
                }
            }
        }

        menuInicial()
    }

    private fun cadastroCodigoDeBarras(){
        print("Digite o código de barras: ")
        code = readln().toInt()
    }

    private fun verificaEqualsTrue(){
        var codigoIgual = false

        for(i: Int in listaDeProdutosCadastrados.indices){
            when(code){
                listaDeProdutosCadastrados[i].codigoDeBarras -> {
                    if(listaDeProdutosCadastrados[i].equals(code)){
                        codigoIgual = true
                        println("* Código de barras existente na loja *")
                    }
                }
            }
        }

        if(!codigoIgual){
            println("* Novo código de barras *")
        }
    }

    private fun selecionarOpcaoMenu(){
        opcMenu = readln().toInt()
    }

    private fun opcaoInvalida(){
        println("Opção inválida")
        println("[1] Livro | [2] CD | [3] DVD")
        print("Digite novamente: ")
        selecionarOpcaoMenu()
    }

    private fun exibirLista(){
        if(listaDeProdutosCadastrados.isEmpty()){
            println("* Lista está vazia *")
        }
        else{
            println("-------- PRODUTOS CADASTRADOS --------")
            listaDeProdutosCadastrados.forEach { produto ->
                produto.mostrarDetalhesDoItem()
            }
        }
        menuInicial()
    }

    private fun buscarProdutoNaLista(){
        if(listaDeProdutosCadastrados.isEmpty()){
            println("* Lista está vazia *")
        }
        else{
            println("Buscar produtos no estoque da loja")
            println("----------------------------------")
            print("Digite o código de barras: ")
            val codigoDigitado = readln().toInt()

            var codigoOk = false

            for(i: Int in listaDeProdutosCadastrados.indices){

                when(codigoDigitado){
                    listaDeProdutosCadastrados[i].codigoDeBarras -> {
                        codigoOk = true
                        println("--------------------------------------")
                        println("Resultado da Busca = ${i+1}º produto: ")
                        listaDeProdutosCadastrados[i].mostrarDetalhesDoItem()
                    }
                }
            }

            if(!codigoOk){
                println("------------------------------------------")
                println("Código de barras não cadastrado no sistema")
                println("------------------------------------------")
                buscarProdutoNaLista()
            }
        }
        menuInicial()

    }

}