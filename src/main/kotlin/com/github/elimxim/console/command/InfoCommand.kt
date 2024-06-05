package com.github.elimxim.console.command

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import com.github.elimxim.console.parameter.SpaceParameterSplitter

@Parameters(commandDescription = "shows information about one or more sorting algorithms")
object InfoCommand {
    const val NAME = "info"

    @Parameter(
            description = "<name> [, <name-2>, ..., <name-20>]",
            splitter = SpaceParameterSplitter::class,
            variableArity = true,
            required = true
    )
    var sortNames: List<String> = arrayListOf()
}