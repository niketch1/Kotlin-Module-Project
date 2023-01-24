import java.util.*

class SelectArchive(override val name: String = "Первый"): Display()
{
    companion object {
        val input = Scanner(System.`in`)
    }

    val archiveList : MutableList<Archive> = mutableListOf()

    fun create(){
        val firstString = Archive("Создать архив")
        val exit = Archive("Выход")
        archiveList.add(firstString)
        archiveList.add(exit)
    }

    override fun createNew(){
        println("Введите название архива:")
        val name = input.nextLine()
        val archive = Archive(name)
        archive.create()
        archiveList.add(1, archive)
    }

    override fun execute(actionNum:Int) : Display? {
        if (actionNum == 0) createNew()
        archiveList.subList(1, (archiveList.lastIndex+1)).forEachIndexed { index, element -> if (actionNum == (index+1)) return element}
        return null
    }

    override fun hello(){
        println("Список архивов:")
        archiveList.forEachIndexed { index, element -> println("$index. ${element.name}") }
    }

    override fun notIsInTheRange(userChoice : String) : Boolean{
        return userChoice.toInt() !in 0..archiveList.lastIndex
    }
}



