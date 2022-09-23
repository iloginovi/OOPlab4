import workwithfile.WorkWithFile
import controller.Controller
import model.Model
import view.ConsoleUi

fun main() {
    println(
        "Player control: w,a,s,d\n" +
                "k-save game\n" +
                "e-quit the game\n" +
                "Reference:\n" +
                "- place to walk\n" +
                "P-player\n" +
                "E-exit from the maze\n" +
                "#-wall\n"
    )
    val workWithFile = WorkWithFile()
    val mod = Model(workWithFile.getLabyrinth().toMutableList())
    ConsoleUi(mod)
    Controller(mod)

}