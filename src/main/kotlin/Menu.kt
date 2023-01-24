import java.util.Scanner

 class Menu {

     companion object {
         val input = Scanner(System.`in`)
     }

     fun start() {
         val archiveList = SelectArchive("Первый")
         archiveList.create()
         watchDisplay(archiveList)
     }

     private fun watchDisplay(display: Display?) {
         while (true) {
             val display1 = selectItem(display!!)
             if (display1 == null) continue
             else {
                 if (exit(display1)) break
                 else {
                     watchDisplay(display1)
                 }
             }
         }
     }

     private fun exit(display: Display?): Boolean {
         if (display!!.name.equals("Выход")) return true
         return false
     }


     fun selectItem(display: Display): Display? {
         display.hello()
         if (!input.hasNextInt()) {
             input.nextLine()
             println("Следует ввести цифру")
         } else {
             val userChoice = input.nextInt()
             if (display.notIsInTheRange(userChoice)) {
                 println("Такой цифры нет")
                 println("Введите корректный символ")
             } else return display.execute(userChoice)
         }
         return null
     }
 }
