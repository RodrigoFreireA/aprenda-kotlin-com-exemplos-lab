enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) //Esta data class armazena os dados imutáveis relacionado ao curso

//Essa data classe armazena os dados da formação com 3 propriedades
data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>() //esta linha rastreia usuarios inscritos

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.hashCode()} matriculado na formação $nome")
    }
}

object Programa {
    @JvmStatic
    fun main(args: Array<String>) {
        val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
        val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos")
        val conteudo3 = ConteudoEducacional("Banco de Dados")

        val formacaoIntermediaria = Formacao("Formação Kotlin Intermediária", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))
        val formacaoBasica = Formacao("Formação Kotlin Básica", Nivel.BASICO, listOf(conteudo1))

        val usuario1 = Usuario()
        val usuario2 = Usuario()

        formacaoIntermediaria.matricular(usuario1)
        formacaoBasica.matricular(usuario2)
    }
}
