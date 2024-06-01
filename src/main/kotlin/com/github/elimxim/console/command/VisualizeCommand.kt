package com.github.elimxim.console.command

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import com.github.elimxim.SortSpeed

@Parameters(commandDescription = "visualizes the selected sorting algorithms")
object VisualizeCommand {
    @Parameter(
            description = "name of the sorting algorithm in camel case",
            required = true
    )
    lateinit var sortName: String

    @Parameter(
            names = ["--speed", "-s"],
            description = "sets the speed for the sorting visualisation: [slow, avg, fast]; " +
                    "if set overrides the '--speedMillis' parameter",
    )
    var speed: String = SortSpeed.NONE.name.lowercase()

    @Parameter(
            names = ["--speedMillis", "--millis", "-m"],
            description = "sets the speed in milliseconds for the sorting visualisation: [50..1000]"
    )
    var speedMillis: String = SortSpeed.AVG.millis.toString()

    @Parameter(
            names = ["--arrayLength", "-l"],
            description = "array length: [10, 30]"
    )
    var arrayLength: String = "20"

    @Parameter(
            names = ["--disableVisualisation", "--noVisualisation", "-nv"],
            description = "disables visualisation"
    )
    var visualisationDisabled: Boolean = false

    @Parameter(
            names = ["--disablePseudoCode", "--noPseudoCode", "-np"],
            description = "switches off display of pseudocode of the selected sorting algorithm"
    )
    var pseudoCodeDisabled: Boolean = false

    @Parameter(
            names = ["--disableInfo", "--noInfo", "-ni"],
            description = "switches off the display of information about the sorting algorithm"
    )
    var infoDisabled: Boolean = false
}