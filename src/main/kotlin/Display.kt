abstract class Display {
    abstract val name : String
    abstract fun execute(actionNum:Int) : Display?
    abstract fun hello()
    abstract fun notIsInTheRange(userChoice : String) : Boolean
    abstract fun createNew()
   /* abstract fun write() : String
    abstract fun noteEquals() : Boolean*/
}

