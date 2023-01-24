import java.util.Scanner

class Archive(override val name: String ) : Display() {

    val archive: MutableList<Note> = mutableListOf()

    companion object {
        val input = Scanner(System.`in`)
    }

    fun create() {
        val firstString = Note("Создать заметку")
        val exit = Note("Выход")
        archive.add(firstString)
        archive.add(exit)
    }

    override fun createNew(){
        println("Введите название заметки:")
        val name = input.nextLine()
        val note = Note(name)
        note.create()
        archive.add(1, note)
    }

    override fun execute(actionNum:Int) : Display? {
        if (actionNum == 0) createNew()
        archive.subList(1, (archive.lastIndex+1)).forEachIndexed { index, element -> if (actionNum == (index+1)) return element}
        return null
    }

    override fun hello(){
        println("Список заметок:")
        archive.forEachIndexed { index, element -> println("$index. ${element.name}") }
    }

    override fun notIsInTheRange(userChoice : Int) : Boolean{
        return userChoice !in 0..archive.lastIndex
    }
}

