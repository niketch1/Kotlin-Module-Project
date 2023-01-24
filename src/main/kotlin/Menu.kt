import java.util.Scanner

 class Menu {

     var display: Display? = null
     var display1: Display? = null
     var display2: Display? = null

     companion object {
         val input = Scanner(System.`in`)
     }

     fun start() {
         val archiveList = SelectArchive("Первый")
         archiveList.create()
         while (true) {
             display = selectItem(archiveList)
             if (display == null) continue
             else {
                 if (display!!.name.equals("Выход")) break
                 else {
                     while (true) {
                         display1 = selectItem(display!!)
                         if (display1 == null) continue
                         else {
                             if (display1!!.name.equals("Выход")) break
                             else {
                                 while (true) {
                                     display2 = selectItem(display1!!)
                                     if (display2 == null) continue
                                     else {
                                         if (display2!!.name.equals("Выход")) break
                                     }
                                 }
                             }
                         }
                     }
                 }
             }
         }
     }


     fun selectItem(display: Display): Display? {
         display.hello()
         val userChoice = input.nextLine()
         if (!userChoice[0].isDigit()) {
             println("Следует ввести цифру")
         } else {
             if (display.notIsInTheRange(userChoice)) {
                 println("Такой цифры нет")
                 println("Введите корректный символ")
             } else return display.execute(userChoice.toInt())
         }
         return null
     }
 }
