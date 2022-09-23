package controller

import model.GAME_NOT_FINISHED
import model.Model
import model.State
import workwithfile.WorkWithFile


class Controller(private val model: Model) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.state in GAME_NOT_FINISHED) {
            val input = readLine().toString()
            var state: State = State.STAY
            for (i in input) {
                when (i) {
                    'w' -> state = State.UP_MOVE
                    'a' -> state = State.LEFT_MOVE
                    's' -> state = State.DOWN_MOVE
                    'd' -> state = State.RIGHT_MOVE
                    'e' -> state = State.EXIT
                    'k' -> saveGame()
                }
                try {
                    model.doMove(state)
                } catch (e: Exception) {
                    println(e.message)
                }
            }
            if (state == State.EXIT)
                break
        }
    }

    private fun saveGame() = WorkWithFile().writeToFile(model.board)
}