import java.util.Scanner

class Note(override val name: String) : Display() {

    var note: MutableList<Text> = mutableListOf()

    companion object {
        val input = Scanner(System.`in`)
    }

    override fun createNew() {
        println("Введите текст заметки:")
        val writing = input.nextLine()
        val text = Text(writing)
        note.set(0, text)
    }

    fun create() {
        val firstString = Text("Написать заметку")
        val exit = Text("Выход")
        note.add(firstString)
        note.add(exit)
    }

    override fun execute(actionNum: Int): Display? {
        if ((note[0].name).equals("Написать заметку")) {
            if (actionNum == 0) createNew()
            note.subList(1, (note.lastIndex + 1))
                .forEachIndexed { index, element -> if (actionNum == (index + 1)) return element }
        } else {
            note.subList(1, (note.lastIndex + 1))
                .forEachIndexed { index, element -> if (actionNum == index) return element }
        }
        return null
    }

    override fun hello() {
        println(name)
        if ((note[0].name).equals("Написать заметку"))
            note.forEachIndexed { index, element -> println("$index. ${element.name}") }
        else {
            println(note[0].name)
            println("0. ${note[1].name}")
        }
    }

    override fun notIsInTheRange(userChoice: Int): Boolean {
        return userChoice !in 0..note.lastIndex
    }
}