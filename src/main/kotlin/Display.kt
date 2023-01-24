abstract class Display {
    abstract val name : String
    abstract fun execute(actionNum:Int) : Display?
    abstract fun hello()
    abstract fun notIsInTheRange(userChoice : Int) : Boolean
    abstract fun createNew()
}

