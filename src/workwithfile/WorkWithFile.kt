package workwithfile

import model.Cell
import java.io.File

class WorkWithFile {
    fun getLabyrinth(): List<String> {
        return File("src/labyrinth.txt").readLines()
    }
    fun writeToFile(elements: List<List<Cell>>){
        val writer = File("src/labyrinth.txt").bufferedWriter()
        for (i in elements) {
            for (j in i) {
                writer.write(j.toString())
            }
            writer.newLine()
        }
        writer.close()
    }
}