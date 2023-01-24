class Text(override val name: String) : Display(){

    override fun execute(actionNum:Int) : Display?{
        val text = Text("text")
        return  text
    }
    override fun hello(){}

    override fun notIsInTheRange(userChoice : String) : Boolean{
        return true
    }

    override fun createNew(){}
}